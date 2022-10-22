package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class NumberTest {

    @Test
    @DisplayName("1에서 45 사이의 로또 번호 1개 생성 성공")
    void createNumberSuccess() {
        assertThat(new Number(1))
                .isExactlyInstanceOf(Number.class);
        assertThat(new Number(22))
                .isExactlyInstanceOf(Number.class);
        assertThat(new Number(45))
                .isExactlyInstanceOf(Number.class);
    }

    @Test
    @DisplayName("1에서 45 사이의 로또 번호 1개 생성 실패")
    void createNumberFail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(-1));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Number(46));
    }
}
