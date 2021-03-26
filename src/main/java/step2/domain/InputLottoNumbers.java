package step2.domain;

import step2.domain.Lotto.LottoNumber;

import java.util.List;

public final class InputLottoNumbers {

    private final List<LottoNumber> InputLottoNumbers;

    private InputLottoNumbers(List<LottoNumber> inputLottoNumbers) {
        this.InputLottoNumbers = inputLottoNumbers;
    }

    public static final InputLottoNumbers newInstance(List<LottoNumber> InputLottoNumbers) {
        return new InputLottoNumbers(InputLottoNumbers);
    }

}
