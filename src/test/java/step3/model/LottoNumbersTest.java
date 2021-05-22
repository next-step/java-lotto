package step3.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    @DisplayName("6개 이상의 숫자를 담을 시 IllegalArgumentException 발생")
    void validationTest() {
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> {
                LottoNumbers lottoNumbers = new LottoNumbers();
                setLottoNumbersOverSix(lottoNumbers);
            });

        assertThat(exception.getMessage()).isEqualTo("6개의 숫자까지만 담을 수 있습니다.");
    }

    @Test
    @DisplayName("size 크기반환 테스트")
    void sizeTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.addNumber(new LottoNumber(1));
        assertThat(lottoNumbers.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 배열을 입력받아 일치하는 갯수 반환 테스트")
    void countWinningTest() {
        LottoNumbers numbers = new LottoNumbers(
            new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        checkThree(numbers);
        checkFour(numbers);
        checkFive(numbers);
        checkSix(numbers);

    }

    private void checkSix(LottoNumbers numbers) {
        assertThat(numbers
            .countWinning(new LottoNumbers(
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)))))
                    .isEqualTo(6);
    }

    private void checkFive(LottoNumbers numbers) {
        assertThat(numbers
            .countWinning(new LottoNumbers(
                new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7)))))
                    .isEqualTo(5);
    }

    private void checkFour(LottoNumbers numbers) {
        assertThat(numbers
            .countWinning(new LottoNumbers(
                new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8)))))
                    .isEqualTo(4);

    }

    private void checkThree(LottoNumbers numbers) {
        assertThat(numbers
            .countWinning(new LottoNumbers(
                new ArrayList<>(Arrays.asList(4, 5, 6, 7, 8, 9)))))
                    .isEqualTo(3);
    }

    private void setLottoNumbersOverSix(LottoNumbers lottoNumbers) {
        for (int index = 1; index <= 10; index++) {
            lottoNumbers.addNumber(new LottoNumber(index));
        }
    }
}
