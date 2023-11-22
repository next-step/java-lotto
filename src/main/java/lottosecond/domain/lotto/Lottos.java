package lottosecond.domain.lotto;

import lottosecond.domain.Money;
import lottosecond.domain.Winner;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.WinningCondition;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos makeTotalLottos(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.lottoList);
        lottos.addAll(autoLottos.lottoList);
        return new Lottos(lottos);
    }

    public WinnerBoard checkWinnerLotto(WinningCondition winningCondition) {
        List<Winner> winners = lottoList.stream()
                .map(lotto -> {
                    int matchCount = lotto.matchNumberCount(winningCondition.getLotto());
                    boolean matchBonusBall = lotto.hasLottoNumber(winningCondition.getBonusBall());
                    return Winner.calculateWinner(matchCount, matchBonusBall);
                })
                .filter(winner -> winner != Winner.NONE)
                .sorted(Comparator.comparingLong(Winner::getPrice))
                .collect(Collectors.toList());

        return new WinnerBoard(winners);
    }

    public int totalLottoBuyMoney() {
        return lottoList.size() * Money.EACH_LOTTO_PRICE;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
