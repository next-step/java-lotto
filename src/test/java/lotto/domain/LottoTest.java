package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("숫자 문자열로 로또 생성")
    void create_with_string_test() {
        String numbers = "2, 43, 44, 11, 41, 42";
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto).isEqualTo(
                new Lotto(Stream.of(2, 11, 41, 43, 44, 42)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()))
        );
    }

    @Test
    @DisplayName("로또 생성 : IllegalArgumentException")
    void create_with_exception() {
        String numbers = "d, 2, 10, 35, 44, 45";
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해 주세요.");
    }

    @Test
    @DisplayName("당첨 로또 확인하기 : 3개 일치")
    void match_3_nums_test() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);

        long result = lotto.matchNumberCnt(
                new Lotto(Stream.of(3, 4, 5, 6, 7)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()))
        );

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("당첨 로또 확인하기 : 0개 일치")
    void match_0_nums_test() {
        List<LottoNumber> numbers = Stream.of(1, 2, 3, 4, 5)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        Lotto lotto = new Lotto(numbers);

        long result = lotto.matchNumberCnt(new Lotto(Stream.of(9, 10, 11, 6, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toList())));

        assertThat(result).isZero();
    }
}
