package step4.lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.lotto.exception.CountException;

public class CountTest {

    @Test
    @DisplayName("양의 정수 문자열로 Count 생성")
    void givenPositiveInteger_whenCreateCount_thenSuccess() {
        // given
        String count = "1";

        // when
        Count number = new Count(count);

        // then
        assertThat(number.value()).isEqualTo(1);
    }

    @Test
    @DisplayName("0으로 Count 생성")
    void givenZero_whenCreateCount_thenSuccess() {
        // given
        String count = "0";

        // when
        Count number = new Count(count);

        // then
        assertThat(number.value()).isEqualTo(0);
    }

    @Test
    @DisplayName("음의 정수 문자열로 Count 생성")
    void givenNegativeInteger_whenCreateCount_thenFail() {
        // given
        String count = "-1";

        // when
        assertThatThrownBy(() -> new Count(count))

            // then
            .isExactlyInstanceOf(CountException.class);
    }

}
