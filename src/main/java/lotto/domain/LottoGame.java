package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final static int LOTTO_INIT_COUNT = 0;
    private final static LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lottos lottos;
    private final LottoBoard lottoBoard;

    private LottoGame(final int lottoAmount, final List<String> lottoStringList) {
        int size = lottoAmount - lottoStringList.size();
        List<Lotto> lottoList = getLottos(lottoStringList, size);
        this.lottos = Lottos.of(lottoList);
        this.lottoBoard = new LottoBoard();
    }

    private List<Lotto> getLottos(List<String> lottoStringList, int size) {
        List<Lotto> lottoList = new ArrayList<>();

        for (String lottoString : lottoStringList) {
            lottoList.add(Lotto.of(lottoGenerator.generateAppointedLotto(lottoString)));
        }

        for (int lottoCount = LOTTO_INIT_COUNT; lottoCount < size; lottoCount++) {
            lottoList.add(Lotto.of(lottoGenerator.generateShuffledLotto()));
        }

        return lottoList;
    }

    public static LottoGame of(final int lottoAmount, final List<String> lottoStringList) {
        return new LottoGame(lottoAmount, lottoStringList);
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
