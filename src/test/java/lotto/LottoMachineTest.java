package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
