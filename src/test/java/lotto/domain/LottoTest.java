package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {
    private Lotto lotto;

    static Stream<Arguments> checkWinningRank() {
        Numbers.Builder builder = Numbers.builder();
        return Stream.of(
                arguments(builder.range(1, 7).build(), 6),
                arguments(builder.range(2, 8).build(), 5),
                arguments(builder.range(3, 9).build(), 4),
                arguments(builder.range(4, 10).build(), 3),
                arguments(builder.range(5, 11).build(), 2)
        );
    }

    @Test
    @DisplayName("로또 1장 생성")
    void createLotto() {
        Numbers numbers = Numbers.builder().range(1, 7).build();

        lotto = new Lotto(size -> numbers);

        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또 생성 시, 숫자가 6개 아니면 에러")
    void createLotto_sizeIsNot6() {
        Numbers numbers = Numbers.builder().range(1, 8).build();
        assertThatThrownBy(() ->
                new Lotto(size -> numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Numbers size wrong");
    }

    @ParameterizedTest
    @DisplayName("당첨 번호와 로또 숫자 비교하여 몇 등 인지 확인")
    @MethodSource
    void checkWinningRank(Numbers numbers, int expectedSameNumberCount) {
        Numbers winningNumbers = Numbers.builder().range(1, 7).build();
        Lotto lotto = new Lotto(size -> numbers);

        int sameNumberCount = lotto.countSameNumber(winningNumbers);

        assertThat(sameNumberCount).isEqualTo(expectedSameNumberCount);
    }

}
