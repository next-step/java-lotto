package step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private static final int LOTTO_NUMBER_CONTAINS_TRUE = 1;
    private static final int LOTTO_NUMBER_CONTAINS_FALSE = 0;

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int lottoWinningPrizes(LottoNumbers lottoNumber, Lotto lotto) {
        return lotto.getLottos()
                .stream()
                .mapToInt(number -> numberContain(number, lottoNumber.getNumber().getLottoNumber()))
                .sum();
    }

    private static int numberContain(LottoNumber number, String lastLottoWinningNumbers) {
        for (LottoNumber lottoNumber : setWinningLottoNumber(lastLottoWinningNumbers)) {
            if (lottoNumber.equals(number)) {
                return LOTTO_NUMBER_CONTAINS_TRUE;
            }
        }
        return LOTTO_NUMBER_CONTAINS_FALSE;
    }

    private static List<LottoNumber> setWinningLottoNumber(String lastLottoWinningNumbers) {
        String[] lastLottoWinningNumber = lastLottoWinningNumbers.split(",");
        return Arrays.stream(lastLottoWinningNumber)
                .map(winningNumber -> new LottoNumber(Integer.parseInt(winningNumber)))
                .collect(Collectors.toList());
    }
}
