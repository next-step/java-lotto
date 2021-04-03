package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_FIRST_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int PRICE_OF_A_PIECE_OF_LOTTO = 1_000;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자는 입력하실 수 없습니다.");
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
