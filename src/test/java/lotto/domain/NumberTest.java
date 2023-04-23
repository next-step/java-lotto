package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("Number 생성")
    void test01() {
        Number number = new Number(3);

        assertThat(number).isEqualTo(new Number(3));
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 아니면 에러를 발생한다.")
    void test02() {
        assertThatThrownBy(() -> new Number(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
