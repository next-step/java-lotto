package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 모두 일치")
    void matches_all() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 13, 16, 18, 20)));
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 5개 일치")
    void matches_5() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 13, 15, 18, 20)));
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 4개 일치")
    void matches_4() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 11, 15, 18, 20)));
        assertThat(result).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 번호 3개 일치")
    void matches_3() {
        Lotto lotto = new Lotto(List.of(1, 10, 13, 16, 18, 20));
        int result = lotto.matches(new Lotto(List.of(1, 10, 11, 15, 17, 20)));
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("범위보다 큰 숫자의 로또 번호 입력 불가")
    void big_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(1, 10, 13, 16, 18, Lotto.MAX + 1)))
                .withMessageContaining("사이의 값이어야 합니다");
    }

    @Test
    @DisplayName("범위보다 작은 숫자의 로또 번호 입력 불가")
    void small_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(List.of(Lotto.MIN - 1, 10, 13, 16, 18, 40)))
                .withMessageContaining("사이의 값이어야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = "1,2,3,4,5 1,2,3,4,5,6,7 1,1,1,1,1,1", delimiter = ' ')
    @DisplayName("로또 번호는 서로 다른 6개로 입력되어야 함")
    void number_count(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).
                collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(numbers))
                .withMessageContaining("개 선택되어야 합니다.");
    }
}
