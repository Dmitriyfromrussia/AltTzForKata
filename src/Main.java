import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = cs.nextLine();
        cs.close();
        Calculator cal = new Calculator();
        String output = cal.calculate(input);

        if(output.length()>40) {
        output=output.substring(0,40);
            System.out.println("\""+output+"..."+"\"");
        }
        else System.out.println("\""+output+"\"");
    }
}
