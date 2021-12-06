package lotto.domain;

import static utils.IntegerValidator.getNumberIfPositive;
import static utils.IntegerValidator.isNumberNegative;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Wallet {

    private static final Map<Integer, Wallet> cache = new HashMap<>();
    private final int money;

    static {
        IntStream.rangeClosed(0, 100)
            .map(number -> number * LottoTicket.PRICE)
            .forEach(money -> cache.put(money, new Wallet(money)));
    }

    public Wallet(int money) {
        this.money = getNumberIfPositive(money);
    }


    public static Wallet create(int money) {
        return cache.getOrDefault(money, new Wallet(money));
    }

    public Wallet spend(int spendMoney) {
        spendValid(spendMoney);

        int preSpendAmount = money - spendMoney;

        return new Wallet(preSpendAmount);
    }

    public int getNumberOfBuyAvailable(int price) {
        return money / price;
    }

    private void spendValid(int spendMoney) {
        if (isNumberNegative(spendMoney)) {
            throw new IllegalArgumentException("지출금액이 음수일 수 없어요.");
        }

        if (money < spendMoney) {
            throw new IllegalArgumentException("보유금액보다 지출금액이 클 수는 없어요.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Wallet wallet = (Wallet) o;
        return money == wallet.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
