package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.prize.LottoPrize;

import java.util.List;

public class Lotto extends BaseLotto {

    private Lotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
    }

    public static Lotto of(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public LottoPrize match(WinningLotto winningLotto) {
        int count = Math.toIntExact(
                lottoNumbers.stream()
                        .filter(winningLotto.getLottoNumbers()::contains)
                        .count());

        return LottoPrize.of(count);
    }
}
