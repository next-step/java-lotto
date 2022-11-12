package automaticlotto.domain;

import automaticlotto.automaticexception.ExceptionCommand;
import automaticlotto.automaticexception.InputValueException;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InputValueException(ExceptionCommand.NUMBER_WINNING_NUMBERS_EXCEPTION_MESSAGE);
        }
        if (lottoNumbers.size() != lottoNumbers.stream().map(LottoNumber::getLottoNumber).distinct().count()) {
            throw new InputValueException(ExceptionCommand.LOTTO_NUMBER_OVERLAP_EXCEPTION_MESSAGE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
