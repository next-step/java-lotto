package lotto.domain;

public class LottoTicket {

    public static final int PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket autoTicket() {
        return new LottoTicket(LottoNumbers.generate());
    }

    public LottoRank rank(LottoNumbers matchTarget, LottoNumber bonusNumber) {
        validateBonusNumber(matchTarget, bonusNumber);
        return LottoRank.of(lottoNumbers().matchCount(matchTarget), lottoNumbers().contains(bonusNumber));
    }

    private void validateBonusNumber(LottoNumbers matchTarget, LottoNumber bonusNumber) {
        if (matchTarget.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨번호가 중복됩니다.");
        }
    }

    public LottoNumbers lottoNumbers() {
        return this.lottoNumbers;
    }
}
