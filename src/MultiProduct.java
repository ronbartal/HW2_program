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
    protected Function derivative() { //TODO: has a problem!
        MultiProduct[] res = new MultiProduct[factorsNum];
        Function[] tempFactors = new Function[factorsNum];

        for (int j = 0; j < factorsNum; j++) {//TODO: make an aux func?
            tempFactors[j] = factors[j].derivative(); // TODO: is it changes "this" factor array?
        }

        for (int i = 0; i < factorsNum; i++) {
            for (int k = i - 1; k >= 0; k--) {
                tempFactors[k + 1] = tempFactors[k];
            }
            tempFactors[0] = factors[i].derivative();
            res[i] = new MultiProduct(tempFactors);

            // Reset tempFactors to the original factors array
            for (int j = 0; j < factorsNum; j++) {
                tempFactors[j] = factors[j].derivative();
            }
        }

        return new MultiSum(res);
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
