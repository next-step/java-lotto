package lotto.domain;

import java.util.Objects;

public class LottoDiscriminator {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 번호는 다른 로또 번호와 중복될 수 없습니다.";

    private final LottoTicket winningTicket;
    private final LottoNumber bonusNumber;

    public LottoDiscriminator(final LottoTicket winningTicket, final LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(winningTicket, bonusNumber);

        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public LottoRank lottoRank(LottoTicket lottoTicket) {
        return LottoRank.valueOf(
                lottoTicket.matchingCount(winningTicket),
                lottoTicket.contains(bonusNumber)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoDiscriminator that = (LottoDiscriminator) o;
        return Objects.equals(winningTicket, that.winningTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningTicket);
    }
}
