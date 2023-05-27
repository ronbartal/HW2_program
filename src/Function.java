public abstract class Function{
    protected abstract double valueAt(double x);

    protected abstract Function derivative();
    @Override
    public abstract String toString();

    ////// find a root

    protected double bisectionMethod(double a, double b, double epsilon){
        //TODO: implement
        return root;
    }
    //overload with epsilon = 10^-5
    protected double bisectionMethod(double a, double b){
        //TODO: implement
        return root;

    }


    protected double newtonRaphsonMethod(double a, double epsilon){
        //TODO: implement
        return root;
    }
    //overload with epsilon = 10^-5
    protected double newtonRaphsonMethod(double a){
        //TODO: implement
        return root;
    }

    //taylor's polynom
    protected Polynomial taylorPolynomial(int n){
        //TODO: implement
    }

}

