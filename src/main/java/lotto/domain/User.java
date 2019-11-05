package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private static String DELIMITER = ", ";
    private final int amount;
    private IssuedLottos issuedLottos;
    private int countOfDirectLottos;

    public User(final int amount) {
        this.amount = amount;
    }

    public void buyLotto(final Store store, final List<String> directLottoNumbers) {
        this.issuedLottos = store.issueLottos(amount, directLottoNumbers);
        this.countOfDirectLottos = directLottoNumbers.size();
    }

    public int getCountOfAutoLottos() {
        return this.issuedLottos.count() - countOfDirectLottos;
    }

    public int getCountOfDirectLottos() {
        return this.countOfDirectLottos;
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
