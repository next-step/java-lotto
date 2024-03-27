package lotto.domain;

public class Budget {

    public static class Lotto {

        private final static int DEFAULT_PRICE = 1000;

        private Price price;
        private int budget;

        public Lotto(int budget) {
            this(budget, DEFAULT_PRICE);
        }

        public Lotto(int budget, int price) {
            this.budget = budget;
            this.price = new Price(price);
        }

        public int purchasableQuantity() {
            return price.divide(budget);
        }
    }
}
