package step3.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int LOTTO_NUMBER_CONTAINS_TRUE = 1;
    private static final int LOTTO_NUMBER_CONTAINS_FALSE = 0;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int lottoWinningPrizes(LottoNumber lottoNumber, Lotto lotto) {
        return lotto.getLottos()
                .stream()
                .mapToInt(number -> numberContain(number, lottoNumber.getLastWeekNumber()))
                .sum();
    }

    private static int numberContain(int number, String lastLottoWinningNumbers) {
        if (lastLottoWinningNumbers.contains(String.valueOf(number))) {
            return LOTTO_NUMBER_CONTAINS_TRUE;
        }
        return LOTTO_NUMBER_CONTAINS_FALSE;
    }
}
