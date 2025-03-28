package step3.lotto.model;

import java.util.ArrayList;
import java.util.List;
import step3.lotto.exception.LottoTicketException;

public class LottoTicket {

    public final static Money PRICE = new Money(1000);
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lottoNumbersDelimitedByComma) {
        validate(lottoNumbersDelimitedByComma);
        lottoNumbers = new ArrayList<>();
        String[] stringLottoNumbers = lottoNumbersDelimitedByComma.replaceAll(" ", "").split(",");
        for (String stringLottoNumber : stringLottoNumbers) {
            lottoNumbers.add(new LottoNumber(stringLottoNumber));
        }
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
    }

    public Count match(LottoTicket lastWeekWinningNumbers) {
        Count matchCount = new Count(0);
        lottoNumbers.stream().filter(lastWeekWinningNumbers.value()::contains).forEach(i -> matchCount.increase());
        return matchCount;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoTicketException();
        }
    }

    private void validate(String lastWeekWinningNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        String[] splitedLastWeekWinningNumbers = lastWeekWinningNumbers.replaceAll(" ", "").split(",");
        for (String winningNumber : splitedLastWeekWinningNumbers) {
            LottoNumber lottoNumber = new LottoNumber(winningNumber);
            lottoNumbers.add(lottoNumber);
        }
        validate(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
