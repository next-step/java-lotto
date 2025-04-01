package domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @DisplayName("로또 번호를 생성한다.")
    @Test
    void createTest() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoNumbers.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("중복이 있는 로또 번호를 생성할 수 없다.")
    @Test
    void createDuplicateTest() {
        try {
            new LottoNumbers(List.of(1, 2, 3, 4, 5, 5));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto numbers must not contain duplicates.");
        }
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외를 발생시킨다.")
    @Test
    void createSizeTest() {
        try {
            new LottoNumbers(List.of(1, 2, 3, 4, 5));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto numbers must contain exactly 6 numbers.");
        }
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외를 발생시킨다.")
    @Test
    void createRangeTest() {
        try {
            new LottoNumbers(List.of(0, 2, 3, 4, 5, 6));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto numbers must be between 1 and 45.");
        }
    }
}
