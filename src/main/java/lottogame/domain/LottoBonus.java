package lottogame.domain;

import java.util.Objects;

public class LottoBonus {

    private final LottoNumber lottoNumber;

    LottoBonus(int bonusNumber, LottoTicket lottoTicket) {
        assertLottoNumber(bonusNumber, lottoTicket);
        this.lottoNumber = LottoNumber.valueOf(bonusNumber);
    }

    private void assertLottoNumber(Integer bonusNumber, LottoTicket lottoTicket) {
        if (lottoTicket.contains(LottoNumber.valueOf(bonusNumber))) {
            throw new IllegalArgumentException(
                String.format("bonusNumber \"%d\"는 lottoTickets\"%s\"와 중복될 수 없습니다.", bonusNumber, lottoTicket));
        }
    }

    boolean isContained(LottoTicket lottoTicket) {
        Objects.requireNonNull(lottoTicket, "lottoTickets는 Null일 수 없습니다.");
        return lottoTicket.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoBonus)) {
            return false;
        }
        LottoBonus that = (LottoBonus) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "LottoBonus{" +
            "lottoNumber=" + lottoNumber +
            '}';
    }
}
