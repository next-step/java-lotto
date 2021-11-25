package lotto;

import java.util.Objects;

/**
 * LottoResult 는 각각의 Lotto 에 대한 결과를 반환할 수 있다.
 */
public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    /**
     * numbers 는 Lotto 로 bonusNumber 는 LottoNumber 로 변환하여 default 생성자에 위임한다.
     * @param numbers
     * @param bonusNumber
     */
    public WinningLotto(String numbers, String bonusNumber) {
        this(new Lotto(numbers), new LottoNumber(bonusNumber));
    }

    /**
     * @DEFAULT_CONSTRUCTOR
     * lotto 하나와 bonusNumber 를 가지고 있는 객체를 생성한다.
     * @param lotto
     * @param bonusNumber
     */
    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        return this.lotto.compare(lotto);
    }

    public boolean hasBonus(Lotto lotto) {
        return lotto.hasBonus(this.bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }
}
