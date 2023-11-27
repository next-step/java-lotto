package step4.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final List<UserLotto> userLottoList;

    public LottoGame(LottoGenerator manualLottoGenerator, LottoGenerator automaticLottoGenerator) {
        this.userLottoList = new ArrayList<>();
        this.userLottoList.addAll(manualLottoGenerator.generate());
        this.userLottoList.addAll(automaticLottoGenerator.generate());
    }

    public List<UserLotto> getUserLottoList() {
        return userLottoList;
    }

    public LottoResult playLottoGame(WinningLotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        this.userLottoList.stream().forEach(userLotto -> {
            int countOfMatch = userLotto.findCountOfMatch(winningLotto);
            boolean hasBonusNumber = userLotto.hasBonusNumber(winningLotto);
            lottoResult.increaseCount(Rank.findRank(countOfMatch, hasBonusNumber));
        });
        return lottoResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(userLottoList, lottoGame.userLottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userLottoList);
    }

    @Override
    public String toString() {
        return "LottoGame{" +
                "userLottoList=" + userLottoList +
                '}';
    }
}
