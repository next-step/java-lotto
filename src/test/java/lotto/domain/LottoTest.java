package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6)), 6L),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7)), 5L),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9)), 4L),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10)), 3L),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 2, 8, 9, 10, 11)), 2L),
            Arguments.of(Lotto.createSpecificLotto(List.of(1, 8, 9, 10, 11, 12)), 1L),
            Arguments.of(Lotto.createSpecificLotto(List.of(21, 22, 23, 24, 25, 26)), 0L)
        );
    }

    @Test
    @DisplayName("랜덤 생성된 로또는 6개의 숫자로 이루어진다.")
    void createSixNumbersTest() {
        //given
        Lotto lotto = Lotto.createRandomLotto();

        //when, then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("랜덤 생성된 로또는 서로 다른 숫자들로 이루어진다.")
    void distinctNumbersTest() {
        //given
        Lotto lotto = Lotto.createRandomLotto();

        //when
        List<LottoNumber> numbers = lotto.getLottoNumbers();

        //then
        assertThat(numbers.stream().distinct().count()).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("숫자를 지정하는 로또 생성 테스트")
    void createSpecificLottoTest() {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(lotto.getLottoNumbers()).isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::of).collect(Collectors.toList()));
    }

    @Test
    @DisplayName("중복된 숫자는 생성 불가.")
    void duplicatedNumberUnavailableTest() {
        assertThrows(IllegalArgumentException.class,
            () -> Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    @Test
    @DisplayName("수동 생성된 로또는 길이가 6이어야 한다.")
    void createSpecificSixNumbersTest() {
        assertThrows(IllegalArgumentException.class,
            () -> Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("일치하는 개수 테스트")
    void countMatchTest(Lotto testLotto, Long match) {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        assertThat(lotto.countMatches(testLotto)).isEqualTo(match);
    }
}
