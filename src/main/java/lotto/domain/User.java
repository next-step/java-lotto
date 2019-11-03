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

    public int countBoughtLotto() {
        return this.issuedLottos.count();
    }

    public IssuedLottos findIssuedLottos() {
        return this.issuedLottos;
    }

    public void checkLottoWin(final String winNumbers) {
        String[] winNumberUnits = winNumbers.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String winNumberUnit : winNumberUnits) {
            numbers.add(Integer.parseInt(winNumberUnit));
        }
        issuedLottos.checkNumbers(numbers);
    }

    public int countWinLotto(final int matchedNumberCount) {
        return this.issuedLottos.countWin(matchedNumberCount);
    }

    public double calculateRate() {
        double three = countWinLotto(3) * 5000.0;
        double four = countWinLotto(4) * 50000.0;
        double five = countWinLotto(5) * 1500000.0;
        double six = countWinLotto(6) * 2000000000.0;
        return Math.floor((three + four + five + six) / amount * 100)/100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return amount == user.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
