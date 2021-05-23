package com.lotto;

import com.lotto.domain.LottoNumber;
import com.lotto.exception.LottoNumberOutOfBoundsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호_생성_실패_예외(int number) {
        Assertions.assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(LottoNumberOutOfBoundsException.class);
    }
}
