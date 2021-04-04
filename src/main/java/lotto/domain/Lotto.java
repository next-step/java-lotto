package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.constant.LottoError;

import java.util.List;

public class Lotto {
    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < LottoConstant.LOTTO_SIZE_MAX) {
            throw new IllegalArgumentException(LottoError.LOTTO_SIZE_OVER_EXCEPTION);
        }
        this.lotto = lottoNumbers;
    }

    public static Lotto of() {
        return of(new RandomGenerator());
    }

    public static Lotto of(LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(lottoNumberGenerator.extractLottoNumber());
    }

    public int getMatchCount(WinningNumber winningNumber) {
        return (int) lotto.stream()
                .filter(winningNumber::contains)
                .count();
    }

    public boolean isMatchBonus(WinningNumber winningNumber) {
        return lotto.stream()
                .anyMatch(winningNumber::isMatchBonus);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lotto;
    }


}
