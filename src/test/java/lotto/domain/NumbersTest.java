package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("다수의 `Number`를 구성하는 로또 번호 `Numbers`에 대한 테스트")
class NumbersTest {

    @DisplayName("랜덤 `Numbers` 생성")
    @Test
    void createRandomNumbersTest() {
        // When
        Numbers randomNumbers = new Numbers();
        // Then
        assertThat(randomNumbers).isNotNull();
    }

    @DisplayName("커스텀 `Numbers` 생성")
    @Test
    void createCustomNumbersTest() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // When
        Numbers customNumbers = new Numbers(numbers);
        // Then
        assertThat(customNumbers).isNotNull();
    }

    @DisplayName("커스텀 `Numbers` 생성 시, 잘못된 숫자로 예외 발생 확인")
    @Test
    void checkExceptionWithInvalidNumbersTest() {
        // Given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // When
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Numbers(invalidNumbers)
        );
    }
}
