public class Constant extends Function{
    final double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    protected double valueAt(double x) {
        return value;
    }

    @Override
    protected Function derivative() {
        return new Constant(0);
    }

    @Override
    public String toString() {
        if (value == (int) value) {
            return "(" + (int) value + ")";
        } else {
            return "(" + value + ")";
        }
    }
}
