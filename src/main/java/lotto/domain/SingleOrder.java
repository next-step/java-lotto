package lotto.domain;

import lotto.constant.ErrorMessage;

public class SingleOrder {
    private final Product product;
    private final int purchaseCount;

    public SingleOrder(Product product, int purchasePrice) {
        this.product = product;
        this.purchaseCount = getPurchaseCount(product, purchasePrice);
    }

    public SingleOrder(String productName, int purchasePrice) {
        this(Product.getProduct(productName), purchasePrice);
    }

    public Product getProduct() {
        return this.product;
    }

    private int getPurchaseCount(Product product, int purchasePrice) {
        if (purchasePrice == 0) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_PURCHASE_PRICE_ERROR.getMessage());
        }

        if (purchasePrice < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_PURCHASE_PRICE_ERROR.getMessage());
        }

        if (purchasePrice % product.getPrice() != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_SINGULAR_PRICE_ERROR.getMessage());
        }

        return purchasePrice / product.getPrice();
    }

    public int getPurchaseAmount() {
        return this.purchaseCount;
    }

    public boolean isOverPurchaseAmount(int amount) {
        return amount > this.getPurchaseAmount();
    }
}
