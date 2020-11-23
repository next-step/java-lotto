package step2.domain;

public class Lotto {
    final int PRICE = 1000;
    int count = 0;

    public Lotto(int purchasePrice) {
        this.count = purchasePrice / this.PRICE;
    }

    public int getCount() {
        return this.count;
    }
}
