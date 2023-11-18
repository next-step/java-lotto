package lottosecond.domain.lotto;

import lottosecond.domain.Winner;
import lottosecond.domain.WinnerBoard;
import lottosecond.domain.WinningLottoAndBonusBall;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    public static final int EACH_LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public WinnerBoard checkWinnerLotto(WinningLottoAndBonusBall winningLottoAndBonusBall) {
        List<Winner> winners = lottoList.stream()
                .map(lotto -> Winner.calculateWinner(lotto, winningLottoAndBonusBall))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        winners.sort(Comparator.comparingLong(Winner::getPrice));

        return new WinnerBoard(winners);
    }

    public int totalLottoBuyMoney() {
        return lottoList.size() * EACH_LOTTO_PRICE;
    }

    public int getLottoCount() {
        return lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }


    private void fillZeroWinnerLottoCount(Map<Integer, Long> winnerLottoCount) {
        IntStream.range(3, 7).boxed()
                        .forEach(key -> winnerLottoCount.putIfAbsent(key, 0L));
    }
}
