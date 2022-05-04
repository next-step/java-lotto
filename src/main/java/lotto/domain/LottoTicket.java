package lotto.domain;

import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 null일 수 없습니다.");
        }

        if (lottoNumbers.size() != NUMBERS_IN_GAME) {
            throw new IllegalArgumentException(String.format("lottoNumbers는 %s여야 합니다.", NUMBERS_IN_GAME));
        }
    }

    public LottoPrize check(LottoNumbers lottoNumbers) {
        return LottoPrize.fromMatch(
                this.lottoNumbers.match(lottoNumbers)
        );
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
