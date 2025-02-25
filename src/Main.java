import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== Select Math ======");
        System.out.println("    1) Algebra");
        System.out.println("    2) Calculus");
        System.out.println("=========================");
        int mathChoice = scanner.nextInt();

        switch (mathChoice) {
            case 1:
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
                break;
            case 2:
                System.out.println("Enter a polynomial (Ex: x^3+x^2+1):");
                String polynomial = scanner.next();

                String derivative = Differentiation.differentiatePolynomial(polynomial);
                System.out.println("The derivative of " + polynomial + " is: " + derivative);

                scanner.close();
                break;
            default:
                System.out.println("Invalid Choice.");
                break;
        }
    }
}
