package lotto.domain;

import lotto.resources.ErrorMessages;

/**
 * 당첨번호 (보너스볼 포함)
 */
public class GoldenTicket {

    private final LottoTicket goldenTicket;
    private final LottoNumber bonusNumber;

    public GoldenTicket(final LottoTicket goldenTicket, final LottoNumber bonusNumber) {
        validateDuplication(goldenTicket, bonusNumber);
        this.goldenTicket = goldenTicket;
        this.bonusNumber = bonusNumber;
    }

    public boolean containsBonusBall(final LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().contains(bonusNumber);
    }

    public int getMatchedNumbersCount(final LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers().stream()
                .filter(lottoNumber -> goldenTicket.getLottoNumbers().contains(lottoNumber))
                .count();
    }

    private void validateDuplication(LottoTicket goldenTicket, LottoNumber bonusNumber){
        if(goldenTicket.getLottoNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(ErrorMessages.DUPLICATION_BONUS_BALL_ERROR_MESSAGE);
        }
    }
}
