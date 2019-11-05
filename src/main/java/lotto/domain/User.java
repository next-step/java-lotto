package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private static String DELIMITER = ", ";
    private final int amount;
    private IssuedLottos issuedLottos;

    public User(final int amount) {
        this.amount = amount;
    }

    public void buyLottoIn(final Store store) {
        this.issuedLottos = store.issueLottos(amount);
    }

    public int getCountOfLottos() {
        return this.issuedLottos.count();
    }

    public IssuedLottos findIssuedLottos() {
        return this.issuedLottos;
    }

    public WinningStatus checkLottoRank(final String winNumbers, final String bonusNumber) {
        final String[] winNumberUnits = winNumbers.split(DELIMITER);
        final List<Integer> numbers = new ArrayList<>();

        for (String winNumberUnit : winNumberUnits) {
            numbers.add(Integer.parseInt(winNumberUnit));
        }

        return issuedLottos.checkRank(numbers, Integer.parseInt(bonusNumber));
    }

    public double calculateRate(final double totalWinningAmount) {
        return Math.floor(totalWinningAmount / amount * 100) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return amount == user.amount &&
                Objects.equals(issuedLottos, user.issuedLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, issuedLottos);
    }
}
