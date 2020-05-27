package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberSelectRuleTest {

    private AutoLottoNumberSelectRule numberSelectRule = new AutoLottoNumberSelectRule();

    @DisplayName("선택된 로또 숫자는 6개이다")
    @Test
    void select_Then_selectedNumberCountIs6() {
        List<Integer> selectedNumber = numberSelectRule.select();
        assertThat(selectedNumber.size()).isEqualTo(6);
    }

    @DisplayName("선택된 로또 숫자는 중복 되지 않는다")
    @Test
    void select_Then_selectedNumberAreUnique() {
        List<Integer> selectedNumber = numberSelectRule.select();
        HashSet<Integer> uniqueSelectedNumber = new HashSet<>(selectedNumber);

        assertThat(selectedNumber.size()).isEqualTo(uniqueSelectedNumber.size());
    }
}
