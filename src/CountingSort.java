public class CountingSort {

    public static void main(String[] args){

        Product[] products = new Product[]{
                new Product("Product A",12.99,5),
                new Product("Product B",9.99,10),
                new Product("Product C",12.99,8),
                new Product("Product D",7.99,15),
                new Product("Product E",9.99,5)
        };

        countSort(products);

        for (Product product: products){
            System.out.println(product.name+": "+product.price+ " " + product.quantity);
        }

    }

    private static Product[] countSort(Product[] products) {
        int size = products.length;
        Product[] output = new Product[size + 1];

        int max = (int) products[0].price;
        for (int i = 1; i < size; i++) {
            if (products[i].price > max) {
                max = (int) products[i].price;
            }
        }
        max ++;
        double[] count = new double[(int) max];

        for (int i = 0; i < max; i++) {
            count[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            count[(int) products[i].price]++;
        }
        for (int i = 1; i < max; i++) {
            count[i] += count[i - 1];
        }
        for (int i = size - 1; i >= 0; i--) {
            output[(int) (count[(int) products[i].price] - 1)] = products[i];
            count[(int) products[i].price]--;
        }

        for (int i = 0; i < size; i++) {
            products[i] = output[i];
        }
        return products;
    }

}

class Product{
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }
}