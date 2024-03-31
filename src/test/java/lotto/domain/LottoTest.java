package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void create_lotto_test() {
        Lotto lotto = Lotto.createFromString("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호 개수 사이즈 예외 테스트")
    void validate_lotto_size_test() {
        assertThatThrownBy(() -> {
            Lotto.of(1, 2, 3, 4, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("예외 메세지 테스트")
    void validate_message_lotto_size_test() {
        Integer[] numbers = IntStream.rangeClosed(1, Lotto.LOTTO_SIZE - 1)
                .boxed()
                .toArray(Integer[]::new);

        assertThatThrownBy(() -> {
            Lotto.of(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Lotto.LOTTO_LENGTH_ERROR_MESSAGE,Lotto.LOTTO_SIZE);
    }

    @ParameterizedTest(name = "{2}개 일치 : LottoNumber = {0}, WinningNumber = {1}")
    @CsvSource(value = {
            "1,2,3,4,5,6 : 1,2,3,4,5,6 : 6",
            "1,2,3,4,5,6 : 1,2,3,4,7,8 : 4"}, delimiter = ':')
    @DisplayName("로또 같은 수 비교 기능 테스트")
    void contain_count_test(String numbers, String winningNumbers, int matchNum) {
        Lotto lotto = Lotto.createFromString(numbers);
        Lotto winningLotto = Lotto.createFromString(winningNumbers);

        assertThat(lotto.matchCount(winningLotto)).isEqualTo(matchNum);
    }
}
