package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void validation_test() {
        List<LottoNumber> numbers = Stream.of(3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Lotto.of(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match_test() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        List<LottoNumber> answer = Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::of)
                .collect(Collectors.toList());

        Lotto lotto = Lotto.of(numbers);

        assertThat(lotto.match(answer, LottoNumber.of(45))).isEqualTo(Rank.FIFTH);
    }
}
