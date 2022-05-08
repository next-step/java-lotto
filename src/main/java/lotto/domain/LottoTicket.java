package lotto.domain;

import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;
    private final LottoTicketType lottoTicketType;

    public LottoTicket(LottoNumbers lottoNumbers, LottoTicketType lottoTicketType) {
        validate(lottoNumbers, lottoTicketType);
        this.lottoNumbers = lottoNumbers;
        this.lottoTicketType = lottoTicketType;
    }

    private void validate(LottoNumbers lottoNumbers, LottoTicketType lottoTicketType) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 null일 수 없습니다.");
        }

        if (lottoTicketType == null) {
            throw new IllegalArgumentException("lottoTicketType은 null일 수 없습니다.");
        }

        if (lottoNumbers.size() != NUMBERS_IN_GAME) {
            throw new IllegalArgumentException(String.format("lottoNumbers는 %s여야 합니다.", NUMBERS_IN_GAME));
        }
    }

    public LottoPrize check(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        return LottoPrize.of(
                this.lottoNumbers.match(lottoNumbers),
                this.lottoNumbers.contains(bonusNumber)
        );
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoTicketType getLottoTicketType() {
        return lottoTicketType;
    }
}
