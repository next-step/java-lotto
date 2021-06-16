package lotto.domain;

import lotto.common.MessageCode;
import lotto.exceptions.NumberRangeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNoTest {

    @Test
    public void Lotto_Number_숫자범위_검증_오류() {
        assertThatThrownBy(() -> new LottoNo(46))
                .isInstanceOf(NumberRangeException.class).hasMessage(MessageCode.INVALID_LOTTO_NUMBER_RANGE.message());

    }

}