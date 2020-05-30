package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private LottoNumber(int bonusNumber, LottoTicket lastWinLottoTicket) {
        this(bonusNumber);
        validateBonusNumber(lastWinLottoTicket);
    }

    public static LottoNumber newInstance(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber newBonusNumber(int bonusNumber, LottoTicket lastWinLottoTicket) {
        return new LottoNumber(bonusNumber, lastWinLottoTicket);
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 까지 입력 가능합니다.");
        }
    }

    private void validateBonusNumber(LottoTicket lastWinLottoTicket) {
        if (lastWinLottoTicket == null) {
            throw new IllegalArgumentException("당첨 번호가 존재하지 않습니다.");
        }

        if (lastWinLottoTicket.isMatchNumber(this)) {
            throw new IllegalArgumentException("당첨 번호에 포함된 번호를 입력할 수 없습니다.");
        }
    }

    public int getLottoNumber() {
        return this.lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(this.lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.lottoNumber - other.getLottoNumber();
    }
}
