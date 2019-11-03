package step2;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Lotto")
class LottoTest {
    private final List<Integer> lottoNumbers = Arrays.asList(8, 21, 23, 41, 42, 43);
    private final List<Integer> lottoNumbersDifferentOrder = Arrays.asList(23, 21, 42, 41, 8, 43);

    @Test
    @DisplayName("should be equal to other one when it's number are same")
    void shouldBeEqualsToWhenLottoNumberIsSame() {
        final Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("can evaluate whether mine is winner")
    void canEvaluateWhetherMineIsWinner() {
        final Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.equalsIgnoreOrder(new Lotto(lottoNumbers))).isTrue();
        assertThat(lotto.equalsIgnoreOrder(new Lotto(lottoNumbersDifferentOrder))).isTrue();
    }
}