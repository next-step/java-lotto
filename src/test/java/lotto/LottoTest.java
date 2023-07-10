package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoTest {

    @Test
    void 로또_객체_생성() {
        // given, when, then
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또_객체_생성시_번호_주입() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        // when & then
        assertThat(lotto.getNumbers())
                .isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::of)
                        .collect(Collectors.toUnmodifiableList()));
    }
}
