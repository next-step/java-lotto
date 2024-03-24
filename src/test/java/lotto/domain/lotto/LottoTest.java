package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    @DisplayName("rank 함수를 통해 로또의 당첨 정보를 확인할 수 있다.")
    @ParameterizedTest(name = "구매번호:{0}, 당첨번호: {1} - 보너스({2}), 예상결과: {3}")
    @MethodSource("rankTestNumbers")
    void rank(String[] purchasedNumbers, String[] winningNumbers, int bonusNumber, Rank expectedRank) {
        final Lotto purchased = new Lotto(purchasedNumbers);
        final Lotto winning = new Lotto(winningNumbers);
        final LottoNumber bonus = new LottoNumber(bonusNumber);

        assertThat(purchased.rank(winning, bonus)).isEqualTo(expectedRank);
    }

    static Stream<Arguments> rankTestNumbers() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.FIRST),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "7"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.SECOND),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "8"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.THIRD),
                Arguments.of(new String[]{"1", "2", "3", "4", "8", "9"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.FOURTH),
                Arguments.of(new String[]{"1", "2", "3", "7", "8", "9"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.FIFTH),
                Arguments.of(new String[]{"1", "2", "7", "8", "9", "10"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.NEXT_CHANCE),
                Arguments.of(new String[]{"1", "8", "9", "10", "11", "12"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.NEXT_CHANCE),
                Arguments.of(new String[]{"7", "8", "9", "10", "11", "12"}, new String[]{"1", "2", "3", "4", "5", "6"}, 7, Rank.NEXT_CHANCE)
        );
    }

    @DisplayName("contains 함수를 통해 로또에 특정 숫자가 포함되어 있는지를 확인할 수 있다.")
    @Test
    void contains() {
        final Lotto purchased = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});

        assertThat(purchased.contains(new LottoNumber(6))).isTrue();
    }

    @DisplayName("matchCount 함수를 통해 두 로또 간의 중복된 번호 갯수를 확인할 수 있다.")
    @Test
    void matchCount() {
        final Lotto purchased = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        final Lotto winningNumbers = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});

        assertThat(purchased.matchCount(winningNumbers).value()).isEqualTo(6);
    }
}
