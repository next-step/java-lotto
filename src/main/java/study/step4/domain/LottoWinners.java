package study.step4.domain;

public class LottoWinners {
    private static final String WINNER_BONUS_DUPLICATE_ERROR = "당첨번호와 보너스번호가 중복됩니다.";
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinners(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        checkDuplicateWinnersInBonus(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicateWinnersInBonus(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        if (winnerNumbers.readOnlyNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(WINNER_BONUS_DUPLICATE_ERROR);
        }
    }

    public int matchOf(LottoTicket lottoTicket) {
        return (int) lottoTicket.readOnlyLottoNumber()
                .stream()
                .filter(this::numberContains)
                .count();
    }

    public boolean bonusOf(LottoTicket lottoTicket) {
        return lottoTicket.readOnlyLottoNumber().contains(bonusNumber);
    }

    public boolean numberContains(LottoNumber number) {
        return winnerNumbers.readOnlyNumbers().contains(number);
    }
}
