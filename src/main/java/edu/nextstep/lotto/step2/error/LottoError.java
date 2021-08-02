package edu.nextstep.lotto.step2.error;

import edu.nextstep.lotto.common.BusinessError;

public enum LottoError implements BusinessError {
    INVALID_VALUE_NOT_NUMBER_FORMAT("숫자만 입력 가능합니다.");

    private final String message;

    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
