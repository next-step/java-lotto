package step2;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step2.domain.LottoNumbers;

public class LottoNumbersTest {
    @Test
    @DisplayName("로또번호 생성 테스트")
    public void lottoSizeTest() {
        LottoNumbers lottoNumbers = LottoNumbers.randomized();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또번호 생성 테스트 - 랜덤한 생성")
    public void lottoNumbersToStringTest() {
        LottoNumbers lottoNumbers = LottoNumbers.randomized();
        assertDoesNotThrow(
            () -> lottoNumbers.validateNumbers(lottoNumbers.numbers())
        );
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 중복된 숫자가 들어있을 경우")
    public void duplicatedNumberTest() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5);
        assertThatThrownBy(
            () -> LottoNumbers.organized(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 숫자가 6개 초과할 경우")
    public void exceedSizeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThatThrownBy(
            () -> LottoNumbers.organized(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호 실패 테스트 - 숫자가 6개 미만일 경우")
    public void underSizeTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(
            () -> LottoNumbers.organized(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
        "1,2,3,4,5,46", // 범위 초과
        "0,1,2,3,4,5" // 범위 미만
    })
    public void rangeNumberTest(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        assertThatThrownBy(
            () -> LottoNumbers.organized(numbers)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("equals test")
    public void equalsTest() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers1 = LottoNumbers.organized(numbers);
        LottoNumbers lottoNumbers2 = LottoNumbers.organized(numbers);
        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @ParameterizedTest
    @CsvSource({
        "6,5,4,3,2,1", // 역순
        "1,3,2,4,5,6", // 랜덤
        "1,2,3,4,5,6" // 정상
    })
    @DisplayName("로또 정렬 테스트")
    public void autoSortTest(int num1, int num2, int num3, int num4, int num5, int num6) {
        List<Integer> numbers = List.of(num1, num2, num3, num4, num5, num6);
        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = LottoNumbers.organized(numbers);
        LottoNumbers sortedLottoNumbers = LottoNumbers.organized(sortedNumbers);
        assertThat(lottoNumbers).isEqualTo(sortedLottoNumbers);
    }
}
