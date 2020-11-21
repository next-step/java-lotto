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
    static Stream<Arguments> getRankMatcher() {
        Numbers.Builder builder = Numbers.builder();
        return Stream.of(
                arguments(new WinningLotto(builder.range(2, 8).build(), new Number(1)), new RankMatcher(5, true)),
                arguments(new WinningLotto(builder.range(2, 8).build(), new Number(9)), new RankMatcher(5, false))
        );
    }

    @Test
    @DisplayName("로또 1장 생성")
    void createLotto() {
        Numbers numbers = Numbers.builder().range(1, 7).build();

        Lotto lotto = new Lotto(size -> numbers);

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
    @DisplayName("당첨 번호와 로또 숫자 비교하여 같은 숫자 개수, 보너스 숫자 match 여부 확인")
    @MethodSource
    void getRankMatcher(WinningLotto winningLotto, RankMatcher expectedRankMatcher) {
        Numbers numbers = Numbers.builder().range(1, 7).build();
        Lotto lotto = new Lotto(size -> numbers);

        RankMatcher rankMatcher = lotto.getRankMatcher(winningLotto);

        assertThat(rankMatcher).isEqualTo(expectedRankMatcher);
    }
}
