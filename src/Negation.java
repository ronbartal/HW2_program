public class Negation extends Function{

    Function function;

    public Negation(Function function) { //TODO: is the logic correct?
        this.function = function;
    }

    @Override
    protected double valueAt(double x) {
        return -function.valueAt(x);
    }

    @Override
    protected Function derivative() {
        return new Negation(function.derivative());
    }

    @Override
    public String toString() {
        return ("(-" + function.toString() +")");
    }
}
