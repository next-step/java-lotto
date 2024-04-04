package lotto.domain;

import lotto.constant.ErrorMessage;

public class Purchase {
    private final Product product;
    private final int purchasePrice;

    public Purchase(Product product, int purchasePrice) {
        if (purchasePrice < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_PRICE_ERROR);
        }

        this.product = product;
        this.purchasePrice = purchasePrice;
    }

    public Purchase(String productName, int purchasePrice) {
        this(Product.getProduct(productName), purchasePrice);
    }

    public Product getProduct() {
        return this.product;
    }

    public int getPurchaseAmount() {
        if (purchasePrice % product.getPrice() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR);
        }

        return this.purchasePrice / product.getPrice();
    }
}
