import java.lang.Math;
public abstract class Function{
    protected abstract double valueAt(double x);

    protected abstract Function derivative();
    @Override
    public abstract String toString();

    ////// find a root

    protected double bisectionMethod(double a, double b, double epsilon){
        //TODO: implement
        double root=0;
        return root;
    }
    //overload with epsilon = 10^-5
    protected double bisectionMethod(double a, double b){
        //TODO: implement
        double root=0;
        return root;

    }


    protected double newtonRaphsonMethod(double a, double epsilon){
        //TODO: implement
        double root=0;
        return root;
    }
    //overload with epsilon = 10^-5
    protected double newtonRaphsonMethod(double a){
        //TODO: implement
        double root=0;
        return root;
    }

    //taylor's polynomial
    protected Polynomial taylorPolynomial(int n){
        double[] coefficients = new double[n+1];
        Function tempFunc = this;
        for (int i = 0; i <= n; i++) {
            coefficients[i] = tempFunc.valueAt(0)/factorial(i);
            tempFunc = tempFunc.derivative();
        }

        return new Polynomial(coefficients);
    }

    private double factorial(int n) {
        if( n == 1 || n == 0 ) {
            return 1;
        }
        double factorial = 1;
        for(int i=1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

}

