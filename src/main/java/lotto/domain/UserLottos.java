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

    public void autoCreate() {
        this.userLottos.add(LottoFactory.createAutoLotto());
    }

    public LottoResults getWinningResults(WinningLotto winningLottoNumber) {
        LottoResults results = new LottoResults();
        for (Lotto lotto : userLottos) {
            results.add(lotto.getRank(winningLottoNumber));
        }
        return results;
    }

    public int getWinningMoney(WinningLotto winningLotto) {
        int sum = 0;
        for (Lotto lotto : userLottos) {
            sum = lotto.getRank(winningLotto).sumRankMoney(sum);
        }
        return sum;
    }

    public List<Lotto> getUserLottos() {
        return Collections.unmodifiableList(userLottos);
    }

    public int getSize() {
        return userLottos.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.userLottos.contains(lottoNumber);
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
