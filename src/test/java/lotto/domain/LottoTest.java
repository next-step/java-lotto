package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 1. 1부터 45까지 정수 6개를 담은 리스트를 가진다.
 * 1-1. 음수 또는 0, 46 이상의 숫자를 가지면 오류를 반환한다.
 * 2. 중복값을 가지면 오류를 반환한다. (size < 6)
 * 3. [1,2,3,4,5,6] 6개의 숫자가 담긴 리스트를 넘기면 Lotto가 생성된다.
 */
public class LottoTest {
    @DisplayName("1부터 45사이의 6개의 숫자가 담긴 리스트를 가지는 Lotto 생성 성공 테스트")
    @Test
    void 유효한_숫자를_가지는_로또() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("음수 또는 0, 46 이상의 숫자를 가지는 Lotto 생성 실패 테스트")
    @ParameterizedTest
    @MethodSource("유효하지_않는_숫자들_리스트_값")
    void 유효하지_않는_숫자를_가지는_로또(List<Integer> value) {
        assertThatThrownBy(() -> {
            new Lotto(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 45까지의 숫자만 가질 수 있습니다.");
    }

    @DisplayName("중복된 값을 가지거나 6개의 숫자를 가지지 않는 Lotto 생성 실패 테스트")
    @ParameterizedTest
    @MethodSource("중복값_알맞지_않는_개수_리스트_값")
    void 중복값_또는_알맞지_않는_개수를_가지는_로또(List<Integer> value) {
        assertThatThrownBy(() -> {
            new Lotto(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복되지 않는 6개의 숫자를 입력해주세요.");
    }

    @Test
    void matchedNumber_count() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int result = lotto.matchedNumber(new Lotto("1, 2, 3, 4, 5, 7"));
        assertThat(result).isEqualTo(5);
    }

    private static Stream<Arguments> 유효하지_않는_숫자들_리스트_값() {
        return Stream.of(
                Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(-1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(46, 47, 48, 49, 50, 60))
        );
    }

    private static Stream<Arguments> 중복값_알맞지_않는_개수_리스트_값() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}
