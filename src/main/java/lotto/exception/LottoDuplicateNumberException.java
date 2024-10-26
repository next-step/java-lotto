package lotto.exception;

import lotto.domain.LottoNumber;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoDuplicateNumberException extends IllegalArgumentException {

    public LottoDuplicateNumberException(Set<LottoNumber> duplicateLottoNumber) {
        super(duplicateLottoNumber.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", ", "중복 요소: ", "가 하나 이상 존재"))
        );
    }

}
