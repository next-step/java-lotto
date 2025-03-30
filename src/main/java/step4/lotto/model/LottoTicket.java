package step4.lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import step4.lotto.exception.LottoTicketInvalidSizeException;

public class LottoTicket {

    public static final int SIZE = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoTicket(lottoNumbers);
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public LottoTicket(String lottoNumbersDelimitedByComma) {
        validateLottoTicket(lottoNumbersDelimitedByComma);
        lottoNumbers = new HashSet<>();
        String[] stringLottoNumbers = lottoNumbersDelimitedByComma.replaceAll(" ", "").split(",");
        for (String stringLottoNumber : stringLottoNumbers) {
            lottoNumbers.add(LottoNumber.of(stringLottoNumber));
        }
    }

    public List<LottoNumber> value() {
        return new ArrayList<>(lottoNumbers);
    }

    public LottoMatchCount matchLottoNumbers(LottoTicket lastWeekWinningNumbers) {
        LottoMatchCount lottoMatchCount = new LottoMatchCount(0);
        lottoNumbers.stream().filter(lastWeekWinningNumbers.value()::contains).forEach(i -> lottoMatchCount.increase());
        return lottoMatchCount;
    }

    public LottoMatchBonusCount matchBonusLottoNumber(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber) ? new LottoMatchBonusCount(1) : new LottoMatchBonusCount(0);
    }

    private void validateLottoTicket(List<LottoNumber> lottoNumbers) {
        if (new HashSet<>(lottoNumbers).size() != LottoTicket.SIZE) {
            throw new LottoTicketInvalidSizeException();
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
