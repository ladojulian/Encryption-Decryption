import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var number = scanner.nextLine();
        do {
            try {
                System.out.println(Integer.parseInt(number) * 10);
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + number);
            }
            number = scanner.nextLine();
        } while (!number.equals("0"));
    }
}