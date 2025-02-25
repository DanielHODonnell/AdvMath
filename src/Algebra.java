// Class to add complex numbers if the root is negative
class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Override
    public String toString(){
        if (imaginary == 0) { // If root is real
            return String.valueOf(real);
        } else if (imaginary >= 0) { // If root is imaginary (i)
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}

public class Algebra extends AdvancedMath {
    public double discriminant(float a, float b, float c) {
        return (b * b) - (4 * a * c);
    }

    public Complex[] quadForm(float a, float b, float c) {
        double discriminant = discriminant(a, b, c);

        if (discriminant >= 0) {
            // Real roots
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double root1 = (-b + sqrtDiscriminant) / (2 * a);
            double root2 = (-b - sqrtDiscriminant) / (2 * a);
            return new Complex[]{new Complex(root1, 0), new Complex(root2, 0)};
        } else {
            // Complex roots
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-discriminant) / (2 * a);
            return new Complex[]{
                    new Complex(realPart, imaginaryPart),
                    new Complex(realPart, -imaginaryPart)
            }; // Returns complex number result
        }
    }

    @Override
    public String toString() {
        return "Algebra{}";
    }
}
