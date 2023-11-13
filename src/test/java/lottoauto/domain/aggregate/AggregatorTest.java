package lottoauto.domain.aggregate;

import lottoauto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AggregatorTest {

    @Test
    @DisplayName("당첨 로또 번호 입력 값에는 6개의 숫자가 있어야 합니다.")
    void sizeSix() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Aggregator aggregator = new Aggregator(List.of(lotto));
        // when
        // then
        assertThatThrownBy(() -> aggregator.checkWinnerLotto("4, 5, 6, 7, 8, 9, 10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨번호는 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 로또 번호 입력 값에는 중복된 숫자가 있으면 안됩니다.")
    void duplicate() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Aggregator aggregator = new Aggregator(List.of(lotto));
        // when
        // then
        assertThatThrownBy(() -> aggregator.checkWinnerLotto("4, 5, 6, 7, 8, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 당첨번호를 작성할 수 없습니다.");
    }

    @Test
    @DisplayName("일치하는 당첨 로또들을 일치 수에 맞도록 winnerBoard 에 추가합니다.")
    void checkLotto() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Aggregator aggregator = new Aggregator(List.of(lotto));
        // when
        aggregator.checkWinnerLotto("4, 5, 6, 7, 8, 9");
        // then
        assertThat(aggregator.getWinnerBoard()).isEqualTo(new WinnerBoard(Map.of(
                3, 1,
                4, 0,
                5, 0,
                6, 0
        )));
    }

    @ParameterizedTest(name = "전달받은 당첨 번호 중에 1보다 작거나 45보다 큰 수가 있으면 안됩니다.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "46, 1, 2, 3, 4, 5"})
    void notValidNumber(String winNumbersString) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Aggregator aggregator = new Aggregator(List.of(lotto));
        // when
        // then
        assertThatThrownBy(() -> aggregator.checkWinnerLotto(winNumbersString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("적절하지 않은 당첨 번호 입니다.");
    }


    @Test
    @DisplayName("상금 보드를 이용해 총 수익률을 계산해줍니다.")
    void calculateEarningRate() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Aggregator aggregator = new Aggregator(List.of(lotto1, lotto2, lotto3));
        aggregator.checkWinnerLotto("4, 5, 6, 7, 8, 9");
        // when
        double earningRate = aggregator.calculateEarningRate();
        // then
        assertThat(earningRate).isEqualTo(3.33);
    }

    @Test
    @DisplayName("총 수익률이 0이 나오는 경우")
    void zeroEarningRate() {
        // given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        Aggregator aggregator = new Aggregator(List.of(lotto1, lotto2, lotto3));
        aggregator.checkWinnerLotto("21, 22, 23, 24, 25, 26");
        // when
        double earningRate = aggregator.calculateEarningRate();
        // then
        assertThat(earningRate).isEqualTo(0);
    }

}