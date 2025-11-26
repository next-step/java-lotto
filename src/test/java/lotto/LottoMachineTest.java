package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    @DisplayName("구입 금액만큼 로또를 발행한다")
    @Test
    void generateLottos() {
        List<Lotto> lottos = LottoMachine.generateLottos(1000);
        assertThat(lottos).hasSize(1);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 900, 1500})
    void invalidMoney(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMachine.generateLottos(money))
                .withMessageContaining("1000원 단위");
    }

    @DisplayName("당첨 통계를 계산한다")
    @ParameterizedTest
    @CsvSource({
            "6, 1",
            "5, 1",
            "0, 1",
            "4, 0",
            "3, 0",
            "2, 0",
            "1, 0",
    })
    void lottoResult(int matchCount, int expectedCount) {
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Map<Integer, Integer> result = LottoMachine.calculateResult(lottos, winningNumbers);
        assertThat(result).hasSize(lottos.size());
        assertThat(result.getOrDefault(matchCount, 0)).isEqualTo(expectedCount);
    }

    @DisplayName("총 당첨금을 계산한다")
    @Test
    void calculateTotalPrize() {
        Map<Integer, Integer> result = Map.of(
                6, 1,
                5, 1,
                3, 2
        );
        long totalPrize = LottoMachine.calculateTotalPrize(result);
        assertThat(totalPrize).isEqualTo(2_000_000_000 + 1_500_000 + 2 * 5_000);
    }

    @DisplayName("당첨금 수익률을 계산한다")
    @Test
    void calculateProfitRate() {
        long totalPrize = 15_000;
        int money = 100_000;
        assertThat(LottoMachine.calculateProfitRate(totalPrize, money)).isEqualTo(0.15);
    }
}
