package lotto.domain;

import java.util.Objects;

public class LottoWinners {
    private static final String WINNER_BONUS_DUPLICATE_ERROR = "당첨번호와 보너스번호가 중복됩니다.";
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinners(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        isDuplicateWinnersInBonus(winnerNumbers, bonusNumber);
        this.winnerNumbers = winnerNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void isDuplicateWinnersInBonus(LottoNumbers winnerNumbers, LottoNumber bonusNumber) {
        boolean result = winnerNumbers.readOnlyNumbers().contains(bonusNumber);

        if (result) {
            throw new IllegalArgumentException(WINNER_BONUS_DUPLICATE_ERROR);
        }
    }

    public boolean matchOf(LottoTicket lottoTicket, int countOfMatch) {
        return (int) lottoTicket.lottoNumber()
                .stream()
                .filter(this::numberContains)
                .count() == countOfMatch;
    }

    public boolean bonusOf(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumber()
                .stream()
                .anyMatch(number -> number.checkNumber(bonusNumber));
    }

    public boolean numberContains(LottoNumber number) {
        return winnerNumbers.readOnlyNumbers().stream()
                .anyMatch(matchNumber -> number.checkNumber(matchNumber));
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinners that = (LottoWinners) o;
        return Objects.equals(winnerNumbers, that.winnerNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNumbers, bonusNumber);
    }
}
