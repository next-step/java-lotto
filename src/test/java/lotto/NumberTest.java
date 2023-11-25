package lotto;

import lotto.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @DisplayName("로또번호 숫자생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호숫자_생성오류테스트(int number) {
        assertThatThrownBy(()-> {
            new Number(number);
                }).isInstanceOf(IllegalArgumentException.class);
    }
}
