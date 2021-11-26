package step3.exception;

import static java.lang.String.format;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import step3.model.LottoNumber;

public class LottoNumberDuplicateException extends RuntimeException {

    private static final String DUPLICATE_ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다. 입력된 수 = %s";

    public LottoNumberDuplicateException(List<LottoNumber> inputLottoNumbers) {
        super(format(DUPLICATE_ERROR_MESSAGE, Arrays.toString(inputLottoNumbers.toArray())));
    }

    public LottoNumberDuplicateException(LottoNumber lottoNumber) {
        this(Collections.singletonList(lottoNumber));
    }
}
