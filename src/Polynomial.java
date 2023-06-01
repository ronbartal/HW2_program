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
        if(degree==0){
            return new Constant(0);
        }
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
        Boolean isFirst = true;
        StringBuilder sb = new StringBuilder("(");
        // if deg == 0
        if(coefficients[0] != 0) {
            if(isRound(coefficients[0])) {
                //down casting
                sb.append((int) coefficients[0]);
            } else {
                sb.append(coefficients[0]);
            }
            isFirst = false;
        }
        // if deg == 1
        if (coefficients[1] == 1) {
            if(!isFirst) {
                sb.append(" + x");
            }
            else{
                isFirst = false;
                sb.append("x");
            }
        }
        else if (coefficients[1] == -1) {
            if(!isFirst) {
                sb.append(" - x");
            }
            else {
                isFirst = false;
                sb.append("-x");
            }
        }
        else if(coefficients[1] != 0) {
            if (coefficients[1] > 0) {
                if(!isFirst) {
                    sb.append(" + ").append(coefficients[1]).append("x");
                }
                else{
                    isFirst = false;
                    sb.append(coefficients[1]).append("x");
                }
            }
            else {
                if(!isFirst) {
                    sb.append(" - ").append(-coefficients[1]).append("x");
                }
                else {
                    isFirst = false;
                    sb.append(-coefficients[1]).append("x");
                }
            }
        }

        for (int i = 2; i <= degree; i++) {
            if (coefficients[i] == 1) {
                if(!isFirst) {
                    sb.append(" + x^").append(i);
                }
                else {
                    isFirst = false;
                    sb.append("x^").append(i);
                }
            }
            else if (coefficients[i] == -1) {
                if(!isFirst) {
                    sb.append(" - x^").append(i);
                }
                else{
                    isFirst = false;
                    sb.append("-x^").append(i);
                }
            }
            else if(coefficients[i] > 0) {
                if(!isFirst) {
                    sb.append(" + ").append(coefficients[i]).append("x^").append(i);
                }
                else {
                    isFirst = false;
                    sb.append(coefficients[i]).append("x^").append(i);
                }
            }
            else if(coefficients[i] < 0){
                if(!isFirst) {
                    sb.append(" - ").append(-coefficients[i]).append("x^").append(i);
                }
                else {
                    isFirst = false;
                    sb.append(coefficients[i]).append("x^").append(i);
                }
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private boolean isRound(double value) {
        if(value == (int) value) return true;
        else return false;
    }
}
