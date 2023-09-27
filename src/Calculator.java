public class Calculator {
    private boolean secondOperandIsString;
    public String calculate(String input) {
        int[] indexOfQuotes = findIndexOfQuotes(input);
        String[] operands = findOperands(input);

        if (operands[0].length()>10 || operands[2].length()>10) throw new RuntimeException();

        if (indexOfQuotes.length == 2) {
            secondOperandIsString = false;
        } else if (indexOfQuotes.length == 4) {
            secondOperandIsString = true;
        } else throw new RuntimeException();

        String operand = operands[1];
        if (operand.equals("+")) return summ(operands[0], operands[2]);
        if (operand.equals("-")) return subtraction(operands[0], operands[2]);
        if (operand.equals("*")) return multiplication(operands[0], operands[2]);
        if (operand.equals("/")) return division(operands[0], operands[2]);
        return null;
    }

   private String summ(String firstString, String secondString) {
       if (!secondOperandIsString) throw new RuntimeException();
       return firstString + secondString;
       }

    private String multiplication(String firstString, String secondString) {
        if (secondOperandIsString) throw new RuntimeException();
        int i = Integer.parseInt(secondString);
        if (i < 0 || i>10) throw new RuntimeException();
        return firstString.repeat(i);
    }

    private String division(String firstString, String secondString) {
        if (secondOperandIsString) throw new RuntimeException();
        int i = Integer.parseInt(secondString);
        if (i < 0 || i>10) throw new RuntimeException();
        int y = firstString.length() / i;
        return firstString.substring(0, y);
    }

    private String subtraction(String firstString, String secondString) {
        if(!secondOperandIsString) throw new RuntimeException();
        if (firstString.endsWith(secondString)) {
            int lenghtSuffix = secondString.length();
            int lenghtSuffixFinal = firstString.length() - lenghtSuffix;
            return firstString.substring(0, lenghtSuffixFinal);
        }
        return firstString;
    }

    private int[] findIndexOfQuotes(String input) {
        int firstQuotesIndex = input.indexOf('"');
        if (firstQuotesIndex != 0) throw new RuntimeException();
        int secondQuotesIndex = input.indexOf('"', firstQuotesIndex + 1);
        int thirdQuotesIndex = input.indexOf('"', secondQuotesIndex + 1);
        int fourthQuotesIndex = input.indexOf('"', thirdQuotesIndex + 1);

        if (thirdQuotesIndex <= 1 & fourthQuotesIndex <= 0) {
            int[] indexOfQuotes = new int[]{firstQuotesIndex, secondQuotesIndex};
            return indexOfQuotes;
        } else {
            int[] indexOfQuotes = new int[]{firstQuotesIndex, secondQuotesIndex, thirdQuotesIndex, fourthQuotesIndex};
            return indexOfQuotes;
        }
    }
    private String[] findOperands(String input) {
        int[] indexOfQuotes = findIndexOfQuotes(input);
        if (indexOfQuotes.length == 4) {
            String[] operands = new String[3];
            operands[0] = input.substring(indexOfQuotes[0] + 1, indexOfQuotes[1]);
            operands[1] = input.substring(indexOfQuotes[1] + 2, indexOfQuotes[2] - 1);
            operands[2] = input.substring(indexOfQuotes[2] + 1, indexOfQuotes[3]);
            return operands;
        } else if (indexOfQuotes.length == 2) {
            String[] operands = new String[3];
            operands[0] = input.substring(indexOfQuotes[0] + 1, indexOfQuotes[1]);
            operands[1] = input.substring(indexOfQuotes[1] + 2, indexOfQuotes[1] + 3);
            operands[2] = input.substring(indexOfQuotes[1] + 4, input.length());
            return operands;
        } else throw new RuntimeException();
    }
}