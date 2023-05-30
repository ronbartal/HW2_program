public class Quotient extends Function{
    Function numerator;
    Function denominator;

    public Quotient(Function numerator, Function denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    protected double valueAt(double x) {
        return numerator.valueAt(x) / denominator.valueAt(x);
    }

    @Override
    protected Function derivative() {
        return new Quotient(new Difference(new Product(numerator.derivative(), denominator),
                new Product(denominator.derivative(), numerator) ),new  Power(denominator,2));
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + " / " + denominator.toString() + ")";
    }
}
