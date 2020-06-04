package lotto;

import lotto.domain.LottoNumbers;
import lotto.infra.domain.AutoLottoNumberSelectRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberSelectRuleTest {

    private AutoLottoNumberSelectRule numberSelectRule = new AutoLottoNumberSelectRule();

    @DisplayName("선택된 로또 숫자는 6개이다")
    @Test
    void select_Then_selectedNumberCountIs6() {
        LottoNumbers selectedNumber = numberSelectRule.select();
        assertThat(selectedNumber.size()).isEqualTo(6);
    }
}
