package lotto.exception;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class AlreadyExistLottoNumberException extends IllegalArgumentException {
    public AlreadyExistLottoNumberException(LottoNumbers numbers, LottoNumber number) {
        super(MessageFormat.format("이미 입력된 당첨 번호입니다. (당첨 번호: {0}, 보너스 번호: {1})", formatLottoNumbers(numbers.get()), number.get()));
    }

    private static List<Integer> formatLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream().map(LottoNumber::get).collect(Collectors.toList());
    }
}
