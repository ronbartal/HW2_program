public class MultiProduct extends Function{
    Function[] factors;
    int factorsNum;


    public MultiProduct(Function... factors){
        this.factorsNum = factors.length;
        this.factors = new Function[factorsNum];
        for (int i = 0; i < factorsNum; i++) {
            this.factors[i] = factors[i];
        }
    }


    @Override
    protected double valueAt(double x) {
        double res = 1;
        for(int i=0; i<factorsNum; i++) {
            res *= factors[i].valueAt(x);
        }
        return res;
    }

    @Override
    protected Function derivative() {
        Function[] derivatives = new Function[factorsNum];

        for (int i = 0; i < factorsNum; i++) {
            Function[] updatedFactors = new Function[factorsNum];
            updatedFactors[0] = factors[i].derivative();
            for (int j = 0, k=1; j < factorsNum; j++) {
                if (j != i) {
                    updatedFactors[k] = factors[j];
                    k++;
                }
            }
            derivatives[i] = new MultiProduct(updatedFactors);
        }

        return new MultiSum(derivatives);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < factorsNum - 1; i++) {
            sb.append(factors[i].toString()).append(" * ");
        }
        sb.append(factors[factorsNum - 1].toString()).append(")");
        return sb.toString();
    }
}
