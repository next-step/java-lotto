package lotto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottos;

    public Lotto() {
        this(LottoNumber.getRandomNumber(LOTTO_NUMBER_COUNT));
    }

    public Lotto(final List<LottoNumber> lottos) {
        this.lottos = lottos;
    }

    public int countMatch(Lotto winLotto) {
        return (int) lottos.stream()
                .filter(lottoNumber -> winLotto.lottos.contains(lottoNumber))
                .count();
    }

}
