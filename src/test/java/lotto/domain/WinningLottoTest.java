package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @DisplayName("우승로또를 생성할 수 있다.")
    @Test
    void from() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
        WinningLotto expected = new WinningLotto(
                IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toSet())
        );

        WinningLotto actual = WinningLotto.from(numbers);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("우승로또와 로또는 같다.")
    @Test
    void winning_lotto_same_lotto() {
        List<String> numbers = List.of("1", "2", "3", "4", "5", "6");
        Lotto expected = Lotto.from(numbers);

        WinningLotto actual = WinningLotto.from(numbers);

        assertThat(actual).isEqualTo(expected);
    }
}
