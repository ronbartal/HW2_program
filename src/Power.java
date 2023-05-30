public class Power extends Function{

    Function function;
    int power;

    public Power(Function function, int power) {
        this.function = function;
        this.power = power;
    }

    @Override
    protected double valueAt(double x) {
        return Math.pow(function.valueAt(x), power);
    }

    @Override
    protected Function derivative() {
        if(power == 1) {
            return function.derivative();
        }
        Constant c= new Constant(power);
        Power temp = new Power(function, power-1);
        return new MultiProduct(c,temp, function.derivative());
    }

    @Override
    public String toString() {
        return "(" + function.toString() + "^" + power + ")";
    }
}
