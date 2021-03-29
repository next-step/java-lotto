package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final static int LOTTO_INIT_COUNT = 0;
    private final static LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lottos lottos;
    private LottoBoard lottoBoard;

    private LottoGame(final int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int lottoCount = LOTTO_INIT_COUNT; lottoCount < lottoAmount; lottoCount++) {
            lottoList.add(Lotto.of(lottoGenerator.generateShuffledLotto()));
        }
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
                .forEach(i -> lottoBoard.calculate(Rank.match(i)));

        this.lottoBoard = lottoBoard;
    }

    public LottoBoard getLottoBoard() {
        return lottoBoard;
    }
}
