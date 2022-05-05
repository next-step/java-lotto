package lotto.domain;

import static lotto.domain.LottoRule.NUMBERS_IN_GAME;

public class LottoResult {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoResult(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("lottoNumbers는 null일 수 없습니다.");
        }

        if (lottoNumbers.size() != NUMBERS_IN_GAME) {
            throw new IllegalArgumentException(String.format("lottoNumbers의 크기(%s)는 %s여야 합니다.", lottoNumbers.size(), NUMBERS_IN_GAME));
        }

        if (bonusNumber == null) {
            throw new IllegalArgumentException("bonusNumber는 null일 수 없습니다.");
        }

        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("bonusNumber(%s)는 lottoNumbers(%s)와 중복될 수 없습니다.", bonusNumber, lottoNumbers));
        }
    }

    public LottoPrizes check(LottoTickets lottoTickets) {
        return lottoTickets.check(lottoNumbers, bonusNumber);
    }
}
