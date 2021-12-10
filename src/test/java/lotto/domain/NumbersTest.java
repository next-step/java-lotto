package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("다수의 `Number`를 구성하는 로또 번호 `Numbers`에 대한 테스트")
class NumbersTest {

    @DisplayName("랜덤 `Numbers` 생성")
    @Test
    void createRandomNumbersTest() {
        // when
        Numbers randomNumbers = new Numbers();
        // then
        assertAll(
                () -> assertThat(randomNumbers).isNotNull(),
                () -> assertThat(randomNumbers.getNumbers()).hasSize(Numbers.TOTAL_SIZE_OF_NUMBERS)
        );
    }

    @DisplayName("커스텀 `Numbers` 생성")
    @Test
    void createCustomNumbersTest() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        Numbers customNumbers = new Numbers(numbers);
        // then
        assertAll(
                () -> assertThat(customNumbers).isNotNull(),
                () -> assertThat(customNumbers.getNumbers()).hasSize(Numbers.TOTAL_SIZE_OF_NUMBERS)
        );
    }

    @DisplayName("커스텀 `Numbers` 생성 시, 잘못된 숫자로 예외 발생 확인")
    @Test
    void checkExceptionWithInvalidNumbersTest() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // when
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Numbers(invalidNumbers)
        );
    }
}
