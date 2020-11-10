package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.exception.LottoNoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNoTest {

    @Test
    @DisplayName("숫자가 아닌 값으로 LottoNo을 만들면, Exception이 발생한다.")
    public void constructor() {
        Assertions.assertAll(
                () -> {
                    assertThatExceptionOfType(LottoNoException.class)
                            .isThrownBy(() -> {
                                new LottoNo(null);
                            }).withMessageMatching(ExceptionConst.NPE_MSG);
                },
                () -> {
                    assertThatExceptionOfType(LottoNoException.class)
                            .isThrownBy(() -> {
                                new LottoNo("NAN");
                            }).withMessageMatching(ExceptionConst.NAN_MSG);
                }
        );

    }
}
