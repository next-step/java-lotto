package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또는")
    @Nested
    class Describe_constructor {

        @DisplayName("로또는 6개의 로또 번호를 생성자로 넘기면 Lotto를 생성한다.")
        @Test
        void it_returns_lotto() {
            final List<LottoNumber> numbers = IntStream.rangeClosed(1, 6)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList());

            assertThatCode(() -> new Lotto(numbers))
                    .doesNotThrowAnyException();
        }

        @DisplayName("로또는 6개의 숫자로 구성된 번호를 생성자로 넘기면 Lotto를 생성한다.")
        @Test
        void it_returns_lotto_when_string_numbers() {
            final String[] input = new String[]{"1", "2", "3", "4", "5", "6"};

            assertThatCode(() -> new Lotto(input))
                    .doesNotThrowAnyException();
        }

        @DisplayName("로또는 6개의 로또 번호를 생성자로 넘기지 않으면 IllegalArgumentException을 발생시킨다.")
        @Test
        void it_throws_illegalException_when_size_is_not_six() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lotto(Collections.emptyList()))
                    .withMessage("로또는 6개의 숫자가 필요합니다.");
        }

        @DisplayName("로또는 중복된 번호를 생성자로 넘기면, IllegalArgumentException을 발생시킨다.")
        @Test
        void it_throws_illegalException_when_numbers_duplicated() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Lotto(new String[]{"1", "2", "3", "4", "5", "5"}))
                    .withMessage("중복되지 않는 번호를 입력해주세요.");
        }

    }

}
