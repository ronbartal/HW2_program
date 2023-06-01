public class Constant extends Polynomial{

    public Constant(double value) {
        super(value);
    }

    @Override
    protected double valueAt(double x) {
        return coefficients[0];
    }

    @Override
    protected Function derivative() {
        return new Constant(0);
    }
}
