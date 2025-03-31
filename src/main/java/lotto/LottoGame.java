package lotto;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LottoGame {

    private final int LOTTO_PRISE = 1000;

    public Lotto[] buyLottos(int money) {
        int buyLottoCount = money / LOTTO_PRISE;
        return IntStream.range(0, buyLottoCount)
                .mapToObj(i -> new Lotto())
                .toArray(Lotto[]::new);

    }

    public WinningLotto getWinningLotto(int[] winningLottoNumbers, int bonusNumber) {
        return new WinningLotto(new Lotto(winningLottoNumbers), new LottoNumber(bonusNumber));
    }

    public LottoRank[] getResults(Lotto[] lottos, WinningLotto winningLotto) {
        return Arrays.stream(lottos)
                .map(winningLotto::getRank)
                .toArray(LottoRank[]::new);
    }
}
