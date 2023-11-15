package lottosecond.domain.lotto;

import lottosecond.domain.WinnerBoard;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottoList;
    public static final int EACH_LOTTO_PRICE = 1000;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public WinnerBoard checkWinnerLotto(String winNumbersString) {
        List<Integer> winNumbers = extractWinningNumbers(winNumbersString);
        Lotto winLotto = new Lotto(winNumbers);

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

    private List<Integer> extractWinningNumbers(String winNumbersString) {
        return Arrays.stream(winNumbersString.split(","))
                .map(strNumber -> Integer.parseInt(strNumber.strip()))
                .collect(Collectors.toList());
    }

    private void fillZeroWinnerLottoCount(Map<Integer, Long> winnerLottoCount) {
        IntStream.range(3, 7).boxed()
                        .forEach(key -> winnerLottoCount.putIfAbsent(key, 0L));
    }
}
