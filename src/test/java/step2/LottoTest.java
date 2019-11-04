package step2;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.lotto.Lotto;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lotto")
class LottoTest {
    private final List<Integer> sequentialLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private final List<Integer> sequentialLottoNumbersDifferentOrder = Arrays.asList(6, 5, 4, 3, 2, 1);

    @Test
    @DisplayName("should be equal to other one when it's number are same")
    void shouldBeEqualsToWhenLottoNumberIsSame() {
        final Lotto lotto = new Lotto(sequentialLottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(sequentialLottoNumbers));
    }

    @Test
    @DisplayName("can be shown using toString()")
    void canBeShownUsingToString() {
        final Lotto lotto = new Lotto(sequentialLottoNumbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("can evaluate whether mine is winner")
    void canEvaluateWhetherMineIsWinner() {
        final Lotto lotto = new Lotto(sequentialLottoNumbers);

        assertThat(lotto.equalsIgnoreNumberOrder(new Lotto(sequentialLottoNumbers))).isTrue();
        assertThat(lotto.equalsIgnoreNumberOrder(new Lotto(sequentialLottoNumbersDifferentOrder))).isTrue();
    }

    @Test
    @DisplayName("can evaluate matched count with bound")
    void canEvaluateMatchedCountWithBound() {
        final Lotto lotto = new Lotto(sequentialLottoNumbers);

        assertThat(lotto.matches(Arrays.asList(1, 2, 3), 3)).isTrue();
        assertThat(lotto.matches(Arrays.asList(1, 2, 3, 4), 4)).isTrue();
        assertThat(lotto.matches(Arrays.asList(1, 2, 3, 4, 5), 5)).isTrue();
        assertThat(lotto.matches(Arrays.asList(1, 2, 3, 4, 5, 6), 6)).isTrue();

        assertThat(lotto.matches(Arrays.asList(2, 3), 2)).isTrue();
        assertThat(lotto.matches(Arrays.asList(7, 8, 9, 10, 11, 12), 0)).isTrue();
    }
}