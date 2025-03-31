package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @DisplayName("로또는 6개의 번호를 갖는다.")
    @Test
    void lottoNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).hasSize(6);
    }

    @DisplayName("로또 번호의 개수가 6개가 아니라면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void lottoNumberCountException() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 번호는 1~45의 범위를 갖는다.")
    @Test
    void lottoNumberRange() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(validNumbers);
        assertThat(lotto.getNumbers()).allSatisfy(number -> {
            assertThat(number).isBetween(1, 45);
        });
    }

    @DisplayName("로또의 번호가 1~45 범위가 아니라면 IllegalArgumentException 예외를 발생시킨다.")
    @Test
    void lottoNumberOutOfRange() {
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Lotto 는 다른 Lotto 와 일치하는 번호의 개수를 확인할 수 있다.")
    @Test
    void checkNumber() {
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(4, 5, 6, 7, 8, 9));

        assertThat(lotto1.countMatchWith(lotto2)).isEqualTo(MatchCount.THREE);
    }

    @DisplayName("Lotto 는 당첨 로또를 통해 당첨 조건에 부합하는지 판단할 수 있다.")
    @ParameterizedTest(name = "{index}: purchased={0}")
    @MethodSource("providePurchasedLottos")
    void confirm(List<Integer> numbers) {
        Lotto purchasedLotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(purchasedLotto.isWinningLotto(winningLotto)).isTrue();
    }

    private static Stream<Arguments> providePurchasedLottos() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
            Arguments.of(List.of(2, 3, 4, 5, 6, 7)),
            Arguments.of(List.of(3, 4, 5, 6, 7, 8)),
            Arguments.of(List.of(4, 5, 6, 7, 8, 9))
        );
    }

}
