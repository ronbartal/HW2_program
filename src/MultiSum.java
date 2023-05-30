public class MultiSum extends Function{
    Function[] members;
    final int functionNum;
    public MultiSum(Function... members){
        this.functionNum = members.length;
        this.members = new Function[functionNum];
        for (int i = 0; i < functionNum; i++) {
            this.members[i] = members[i];
        }
    }

    @Override
    protected double valueAt(double x) {
        double sum=0;
        for (int i = 0; i < functionNum; i++) {
            sum+=members[i].valueAt(x);
        }
        return sum;
    }

    @Override
    protected Function derivative() {
        Function[] res= new Function[functionNum];
        for (int i = 0; i < functionNum; i++) {
            res[i]= members[i].derivative(); //TODO: check this out
        }
        return new MultiSum(res);
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < functionNum - 1; i++) {
            sb.append(members[i].toString()).append(" + ");
        }
        sb.append(members[functionNum - 1].toString()).append(")");
        return sb.toString();
    }
    //another way to implement
    /* public String toString() {
        String res="(";
        for (int i = 0; i < functionNum-1; i++) {
            res += members[i].toString() + "+";
        }
        return res + members[functionNum-1].toString()+ ")";
    }
    */
}
