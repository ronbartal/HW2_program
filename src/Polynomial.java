public class Polynomial extends Function {
    final int degree;
    final double[] coefficients;

    public Polynomial(double... coefficients) {
        this.degree = coefficients.length - 1;
        this.coefficients = new double[degree + 1];
        for (int i = 0; i <= degree; i++) {
            this.coefficients[i] = coefficients[i];
        }
    }


//TODO: implement override
    @Override
    protected double valueAt(double x) {
        return 0;
    }

    @Override
    protected Function derivative() {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}
