package lotto.domain;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public void sellTo(Person person) {
        int num = person.amount() / LOTTO_PRICE;
        for (int i = 0; i < num; i++) {
            person.buy();
        }
    }
}
