package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberSizeException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(createLottoNumberSet(1, 6));
    }

    @DisplayName("생성할 때")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Create {

        @DisplayName("List<String>타입을 파라미터로 받을 수 있다.")
        @Test
        void create_by_List() {
            Lotto expected = lotto;
            Lotto actual = Lotto.from(
                    IntStream.rangeClosed(1, 6)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.toList())
            );

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("String 타입을 파라미터로 받을 수 있다.")
        @Test
        void create_by_string() {
            Lotto expected = lotto;
            Lotto actual = Lotto.from("1,2,3,4,5,6");

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("숫자 개수가 6개가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @MethodSource("generateInvalidSizeElements")
        void validate_size(Set<LottoNumber> elements) {
            assertThatThrownBy(() -> new Lotto(elements))
                    .isExactlyInstanceOf(InvalidLottoNumberSizeException.class)
                    .hasMessage("올바르지 않은 로또 숫자 개수 입니다. 올바른 숫자 개수(중복제외) : 6");
        }

        private Stream<Set<LottoNumber>> generateInvalidSizeElements() {
            return Stream.of(
                    createLottoNumberSet(1, 5),
                    createLottoNumberSet(1, 7)
            );
        }
    }

    @DisplayName("중복되는 숫자의 개수를 반환한다.")
    @Test
    void count_matches() {
        Lotto lastWeekLotto = new Lotto(createLottoNumberSet(3, 8));

        int actual = lotto.countMatches(lastWeekLotto);

        assertThat(actual).isEqualTo(4);
    }

    @DisplayName("로또번호 포함여부를 반환한다.")
    @Test
    void contains() {
        Lotto lotto = new Lotto(createLottoNumberSet(3, 8));

        boolean actual = lotto.contains(new LottoNumber("3"));

        assertThat(actual).isTrue();
    }

    private Set<LottoNumber> createLottoNumberSet(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
