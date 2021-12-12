package lottobefore.domain;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public void sellTo(Person person) {
        validate(person);
        int num = person.amount() / LOTTO_PRICE;
        for (int i = 0; i < num; i++) {
            person.buy();
        }
    }

    private void validate(Person person) {
        if (person.amount() < LOTTO_PRICE) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }
    }
}
