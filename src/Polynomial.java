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
        double res=0;
        for (int i = 0; i <= degree; i++) {
            res+= coefficients[i] * Math.pow(x,i);
        }
        return res;
    }

    @Override
    protected Function derivative() {
        if (degree==1){
            return new Constant(coefficients[1]);
        }
        double[] resCoefficients = new double[degree];
        for (int i = 1; i <= degree; i++) {
            resCoefficients[i-1] = coefficients[i] * i;
        }
        return new Polynomial(resCoefficients);
    }

    @Override
    public String toString() {
        return null;
    }
}
