package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {

    @Test
    @DisplayName("getMatchingNumberCount 메서드에 null을 전달하면 0이 반환된다.")
    void getMatchingNumberCountParameterIsNullTest() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getMatchingNumberCount(null)).isZero();
    }

    @Test
    @DisplayName("getMatchingNumberCount 메서드가 일치하는 로또번호 개수를 반환한다.")
    void getMatchingNumberCountTest() {
        Lotto lotto1 = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Set.of(1, 2, 3, 14, 15, 16));
        assertThat(lotto1.getMatchingNumberCount(lotto2)).isEqualTo(3);
    }

    @Test
    @DisplayName("Lotto 객체를 생성할 때 로또 번호가 6개가 아니면 예외가 발생한다.")
    void initDuplicateNumberTest() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호의 개수가 일치하지 않습니다.");
    }

    @ParameterizedTest
    @MethodSource("initInvalidLottoNumbers")
    @DisplayName("Lotto 객체를 생성할 때 로또번호가 1이상 45이하인 숫자가 포함되면 예외가 발생한다.")
    void initNumberSizeTest(Set<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 로또 번호가 아닙니다.(1이상 45이하 아님)");
    }

    private static Stream<Arguments> initInvalidLottoNumbers() {
        return Stream.of(
                arguments(Set.of(-1, 1, 2, 3, 4, 5)),
                arguments(Set.of(46, 1, 2, 3, 4, 5))
        );
    }
}