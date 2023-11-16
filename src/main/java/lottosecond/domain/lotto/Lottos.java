package lottosecond.domain.lotto;

import lottosecond.domain.WinnerBoard;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    public static final int EACH_LOTTO_PRICE = 1000;

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public WinnerBoard checkWinnerLotto(List<LottoNumber> winNumbers) {
        if (winNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }

        Lotto winLotto = new Lotto(new HashSet<>(winNumbers));

        Map<Integer, Long> winnerLottoCount = lottoList.stream()
                .map(lotto -> lotto.getLottoScore(winLotto))
                .filter(score -> score >= 3)
                .collect(Collectors.groupingBy(
                        score -> score,
                        Collectors.counting()
                ));
        fillZeroWinnerLottoCount(winnerLottoCount);

        return new WinnerBoard(winnerLottoCount);
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
