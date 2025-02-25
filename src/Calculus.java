import java.util.ArrayList;
import java.util.List;

public class Calculus {
    // Declare variables
    double coefficient;
    String variable;
    int exponent;

    Calculus(double coefficient, String variable, int exponent) {
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }

    // Differentiate the term using the power rule
    Calculus differentiate() {
        if (exponent == 0) { // Derivative of a constant is 0
            return new Calculus(0, variable, 0);
        }
        return new Calculus(coefficient * exponent, variable, exponent - 1);
    }

    @Override
    public String toString() {
        if (exponent == 0) {
            return String.valueOf(coefficient);
        } else if (exponent == 1) {
            return coefficient + variable;
        } else {
            return coefficient + variable + "^" + exponent;
        }
    }
}

class Differentiation extends AdvancedMath{

    // Parse a polynomial string into a list of terms
    static List<Calculus> parsePolynomial(String polynomial) {
        List<Calculus> terms = new ArrayList<>();
        String[] termStrings = polynomial.split("(?=[+-])"); // Split on + or - (lookahead)

        for (String termStr : termStrings) {
            termStr = termStr.trim();
            if (termStr.isEmpty()) continue;

            termStr = termStr.replaceAll("\\s*\\*\\s*", "");

            // Extract coefficient, variable, and exponent
            String[] parts = termStr.split("[x^]");
            double coefficient;
            String variable;
            int exponent;

            // Handle coefficient
            if (parts[0].isEmpty() || parts[0].equals("+")) {
                coefficient = 1;
            } else if (parts[0].equals("-")) {
                coefficient = -1;
            } else {
                coefficient = Double.parseDouble(parts[0]);
            }

            // Handle variable and exponent
            if (parts.length > 1) {
                variable = "x";
                exponent = parts.length > 2 ? Integer.parseInt(parts[2]) : 1;
            } else {
                variable = "";
                exponent = 0;
            }

            terms.add(new Calculus(coefficient, variable, exponent));
        }

        return terms;
    }

    // Differentiate a polynomial
    public static String differentiatePolynomial(String polynomial) {
        List<Calculus> terms = parsePolynomial(polynomial);
        StringBuilder result = new StringBuilder();

        for (Calculus term : terms) {
            Calculus derivative = term.differentiate();
            if (derivative.coefficient != 0) {
                if (!result.isEmpty() && derivative.coefficient > 0) {
                    result.append("+");
                }
                result.append(derivative);
            }
        }

        return result.toString();
    }
}

