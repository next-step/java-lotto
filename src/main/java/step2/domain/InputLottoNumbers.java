package step2.domain;

import step2.domain.Lotto.LottoNumber;
import step2.exception.ListNullPointerException;

import java.util.List;

public final class InputLottoNumbers {

    private final List<LottoNumber> InputLottoNumbers;

    private InputLottoNumbers(List<LottoNumber> inputLottoNumbers) {
        if(isListNull(inputLottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.InputLottoNumbers = inputLottoNumbers;
    }

    public static final InputLottoNumbers newInstance(List<LottoNumber> InputLottoNumbers) {
        return new InputLottoNumbers(InputLottoNumbers);
    }

    private final boolean isListNull(List<LottoNumber> inputLottoNumbers) {
        return inputLottoNumbers == null;
    }

}
