package step3.lotto.model;

import java.util.ArrayList;
import java.util.List;
import step3.lotto.exception.LottoTicketException;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoTicket(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lottoNumbersDelimitedByComma) {
        validateLottoTicket(lottoNumbersDelimitedByComma);
        lottoNumbers = new ArrayList<>();
        String[] stringLottoNumbers = lottoNumbersDelimitedByComma.replaceAll(" ", "").split(",");
        for (String stringLottoNumber : stringLottoNumbers) {
            lottoNumbers.add(LottoNumber.of(stringLottoNumber));
        }
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
    }

    public LottoMatchCount matchLottoNumbers(LottoTicket lastWeekWinningNumbers) {
        LottoMatchCount lottoMatchCount = new LottoMatchCount(0);
        lottoNumbers.stream().filter(lastWeekWinningNumbers.value()::contains).forEach(i -> lottoMatchCount.increase());
        return lottoMatchCount;
    }

    public LottoMatchBonusCount matchBonusLottoNumber(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber) ? new LottoMatchBonusCount(1) : new LottoMatchBonusCount(0);
    }

    public LottoPrize scratch(LottoTicketWinner lastWeekWinningTicket) {
        return lastWeekWinningTicket.match(this);
    }

    private void validateLottoTicket(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoTicketException();
        }
    }

    private void validateLottoTicket(String lastWeekWinningNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        String[] splitedLastWeekWinningNumbers = lastWeekWinningNumbers.replaceAll(" ", "").split(",");
        for (String winningNumber : splitedLastWeekWinningNumbers) {
            LottoNumber lottoNumber = LottoNumber.of(winningNumber);
            lottoNumbers.add(lottoNumber);
        }
        validateLottoTicket(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
