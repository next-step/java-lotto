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

    @DisplayName("로또 1장에 6개의 번호가 생성된다")
    @Test
    void generateSixNumbers() {
        List<Integer> generated = LottoMachine.generateLotto();
        assertThat(generated).hasSize(6);
    }

    @DisplayName("구입 금액만큼 로또를 발행한다")
    @Test
    void generateLottos() {
        List<List<Integer>> lottos = LottoMachine.generateLottos(1000);
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

    @DisplayName("당첨 번호와 발행된 로또 번호를 비교해 일치하는 개수를 반환한다")
    @Test
    void compareNumbers() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 7);
        int result = LottoMachine.countMatches(lotto, winningNumbers);
        assertThat(result).isEqualTo(5);
    }

    @DisplayName("일치하는 번호가 없으면 0을 반환한다")
    @Test
    void compareNumbers_NoneEqual() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(7, 8, 9, 10, 11, 12);
        int result = LottoMachine.countMatches(lotto, winningNumbers);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("전부 일치하면 6을 반환한다")
    @Test
    void compareNumbers_AllEqual() {
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int result = LottoMachine.countMatches(lotto, winningNumbers);
        assertThat(result).isEqualTo(6);
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
        List<List<Integer>> lottos = List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 7), List.of(7, 8, 9, 10, 11, 12));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
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
}
