import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean Algebra = false;
        boolean Calculus = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("====== Select Math ======");
        System.out.println("    1) Algebra");
        System.out.println("    2) Calculus");
        System.out.println("=========================");
        int mathChoice = scanner.nextInt();

        switch (mathChoice) {
            case 1:
                Algebra = true;
                break;
            case 2:
                Calculus = true;
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
        }

        if (Algebra) {
            Algebra algebra = new Algebra();


            System.out.println("Enter coefficient for 'a' in Quadratic Formula:");
            float a = scanner.nextFloat();

            System.out.println("Enter coefficient for 'b' in Quadratic Formula:");
            float b = scanner.nextFloat();

            System.out.println("Enter coefficient for 'c' in Quadratic Formula:");
            float c = scanner.nextFloat();

            Complex[] roots = algebra.quadForm(a, b, c);
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);

            scanner.close();
        }
        else if (Calculus) {
            // String polynomial must be in terms of one variable.
            System.out.println("Enter a polynomial (Ex: x^2): ");
            String polynomial = scanner.nextLine();

            String derivative = Differentiation.differentiatePolynomial(polynomial);
            System.out.println("The derivative of " + polynomial + " is: " + derivative);

            scanner.close();
        }

    }
}
