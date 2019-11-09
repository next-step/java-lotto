package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static final String WINNING_NUMBERS_DELIMITER = ", ";
    private final int money;
    private Lottos lottos;

    public User(final int money) {
        this.money = money;
    }

    public void buyLottosIn(final Store store, final List<String> directLottos) {
        this.lottos = store.issueLotto(money, directLottos);
    }

    public WinningLottos checkLottos(final String winningNumbersInput, final int bonusNumber) {
        final String[] splitWinningNumber = winningNumbersInput.split(WINNING_NUMBERS_DELIMITER);
        final List<LottoNumber> winningLottoNumbers = new ArrayList<>();

        for (String winningNumber : splitWinningNumber) {
            winningLottoNumbers.add(LottoNumber.of(Integer.parseInt(winningNumber)));
        }

        return lottos.checkWinning(winningLottoNumbers, bonusNumber);
    }

    public Lottos findLottos() {
        return lottos;
    }

    public int findCountOfDirectLottos() {
        return lottos.findCountOfDirectLottos();
    }

    public int findCountOfAutoLottos() {
        return lottos.findCountOfAutoLottos();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return money == user.money &&
                Objects.equals(lottos, user.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, lottos);
    }
}
