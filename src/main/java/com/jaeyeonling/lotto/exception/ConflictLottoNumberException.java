package com.jaeyeonling.lotto.exception;

import com.jaeyeonling.lotto.domain.LottoNumber;

public class ConflictLottoNumberException extends IllegalStateException {

    private static final String ERROR_MESSAGE = "보너스 번호는 당첨 번호와 겹칠 수 없습니다. (입력 값: %s)";

    public ConflictLottoNumberException(final LottoNumber conflictLottoNumber) {
        super(String.format(ERROR_MESSAGE, conflictLottoNumber));
    }
}
