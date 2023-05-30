public class Product extends MultiProduct {
    //TODO: anything?

    public Product(Function f, Function g){
        super(f,g);
    }

    @Override
    protected Function derivative() {
        return new Sum(new Product(factors[0].derivative(),factors[1]), new Product(factors[1].derivative(),factors[0]));
    }
}
