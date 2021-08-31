package utilities;

public class ProductSearch {
    String product;
    int dolarsPrice;

    public ProductSearch(String productName, int value){
        this.product = productName;
        this.dolarsPrice = value;
    }

    public String getProductName() {
        return product;
    }
    public int getValue() {
        return dolarsPrice;
    }

    public void setProductName(String productName) {
        this.product = productName;
    }
    public void setValue(int value) {
        this.dolarsPrice = value;
    }
}
