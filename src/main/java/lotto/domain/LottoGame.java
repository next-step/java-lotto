package lotto.domain;

import lotto.domain.enums.LottoMatcher;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

    private final static int LOTTO_START_INCLUSIVE_VALUE = 0;
    private final static LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lottos lottos;
    private LottoBoard lottoBoard;

    private LottoGame(final int lottoAmount) {
        List<Lotto> lottoList = IntStream.range(LOTTO_START_INCLUSIVE_VALUE, lottoAmount)
                .mapToObj(i ->
                        Lotto.of(lottoGenerator.generateShuffledLotto())
                )
                .collect(Collectors.toList());

        this.lottos = Lottos.of(lottoList);
    }

    public static LottoGame of(final int lottoAmount) {
        return new LottoGame(lottoAmount);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void calculateWinnings(WinningNumber winningNumber) {
        LottoBoard lottoBoard = new LottoBoard();
        lottos.stream()
                .map(lotto -> winningNumber.getLottoMatchCount(lotto))
                .forEach(i -> lottoBoard.calculate(LottoMatcher.match(i)));

        this.lottoBoard = lottoBoard;
    }

    public LottoBoard getLottoBoard() {
        return lottoBoard;
    }
}
