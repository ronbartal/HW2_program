public class Difference extends Function{
    Function subtracted;
    Function subtracting;

    public Difference(Function subtracted, Function subtracting){
        this.subtracted=subtracted;
        this.subtracting=subtracting;

    }
    @Override
    protected double valueAt(double x) {
        return subtracted.valueAt(x) - subtracting.valueAt(x);
    }

    @Override
    protected Function derivative() {
        return new Difference(subtracted.derivative(), subtracting.derivative());
    }

    @Override
    public String toString() {
        return "(" + subtracted.toString() + " - " + subtracting.toString() + ")";
    }
}
