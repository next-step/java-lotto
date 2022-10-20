package lotto.domain;

import lotto.util.NullCannotBeConstructorArgException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoPaperTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        private final List<String> stringNumbers = List.of(
                "1,2,3,4,5,6",
                "11,12,13,14,15,16",
                "21,22,23,24,25,26"
        );
        private List<Lotto> lottos;

        @BeforeEach
        void setUp() {
            lottos = stringNumbers.stream()
                            .map(Lotto::from)
                            .collect(Collectors.toList());
        }

        @DisplayName("로또 숫자가 있는 문자열들로 생성할 수 있다.")
        @Test
        void create_by_string_list() {
            LottoPaper expected = new LottoPaper(lottos);

            LottoPaper actual = LottoPaper.from(stringNumbers);

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("생성할때 인자값이 null이면 예외가 발생한다.")
        @Test
        void validate_null() {
            assertThatThrownBy(() -> new LottoPaper(null))
                    .isExactlyInstanceOf(NullCannotBeConstructorArgException.class)
                    .hasMessage("Null은 생성자의 인자가 될 수 없습니다.");
        }
    }
}
