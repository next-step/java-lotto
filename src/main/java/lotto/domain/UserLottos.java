package lotto.domain;

import java.util.*;

public class UserLottos {
    private final List<Lotto> userLottos;

    public UserLottos() {
        this(new ArrayList<>());
    }

    public UserLottos(List<Lotto> buyLottoNumbers) {
        this.userLottos = buyLottoNumbers;
    }

    public void createManual(Lotto lotto) {
        this.userLottos.add(lotto);
    }

    public void createAuto() {
        this.userLottos.add(LottoFactory.createAutoLotto());
    }

    public LottoResults getWinningResults(WinningLotto winningLottoNumber) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : userLottos) {
            results.add(lotto.getRank(winningLottoNumber));
        }
        return results;
    }

    public Money getWinningMoney(WinningLotto winningLotto) {
        Money moneySum = new Money();
        for (Lotto lotto : userLottos) {
            moneySum = lotto.getRank(winningLotto).sumWinningMoney(moneySum);
        }
        return moneySum;
    }

    public List<Lotto> getBuyLottos() {
        return Collections.unmodifiableList(userLottos);
    }

    public int getSize() {
        return userLottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLottos that = (UserLottos) o;
        return Objects.equals(userLottos, that.userLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottos);
    }

    @Override
    public String toString() {
        StringBuilder lottoNumbers = new StringBuilder();
        for (Lotto lottoNumber : this.userLottos) {
            lottoNumbers.append(lottoNumber.toString()).append("\n");
        }
        return lottoNumbers.toString();
    }

}
