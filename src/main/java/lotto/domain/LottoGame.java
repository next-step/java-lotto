package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final static int LOTTO_INIT_COUNT = 0;
    private final static LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lottos lottos;
    private final LottoBoard lottoBoard;

    private LottoGame(final int lottoAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int lottoCount = LOTTO_INIT_COUNT; lottoCount < lottoAmount; lottoCount++) {
            lottoList.add(Lotto.of(lottoGenerator.generateShuffledLotto()));
        }
        this.lottos = Lottos.of(lottoList);
        this.lottoBoard = new LottoBoard();
    }

    public static LottoGame of(final int lottoAmount) {
        return new LottoGame(lottoAmount);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public void calculateWinnings(WinningNumber winningNumber) {
        lottos.stream()
                .map(winningNumber::rankMatch)
                .forEach(lottoBoard::calculate);
    }

    public LottoBoard getLottoBoard() {
        return lottoBoard;
    }
}
