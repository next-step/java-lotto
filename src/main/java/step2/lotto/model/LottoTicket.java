package step2.lotto.model;

import java.util.ArrayList;
import java.util.List;
import step2.lotto.exception.LottoTicketException;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public LottoTicket(String lastWeekWinningNumbers) {
        validate(lastWeekWinningNumbers);
        lottoNumbers = new ArrayList<>();
        String[] splitedLastWeekWinningNumbers = lastWeekWinningNumbers.replaceAll(" ", "").split(",");
        for (String winningNumber : splitedLastWeekWinningNumbers) {
            lottoNumbers.add(new LottoNumber(winningNumber));
        }
    }

    public List<LottoNumber> value() {
        return lottoNumbers;
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
