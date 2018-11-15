package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static lotto.utils.LottoNumberGenerator.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @Before
    public void setup() {
        List<LottoNo> numbers = generate(1, 10, 15, 20, 25, 30);
        LottoNo bonusNumber = LottoNo.create(35);
        winningLotto = WinningLotto.create(numbers, bonusNumber);
    }

    @Test
    public void 숫자목록과_보너스번호로_당첨로또를_생성할수있다() {
        assertThat(winningLotto).isNotNull();
    }

    @Test
    public void 당첨번호를_얻을수있다() {

        assertThat(winningLotto.getNumbers()).isEqualTo(generate(1, 10, 15, 20, 25, 30));
    }

    @Test
    public void 보너스번호가_포함된_당첨번호를_얻을수있다() {
        assertThat(winningLotto.getNumbersWithBonus()).isEqualTo(generate(1, 10, 15, 20, 25, 30, 35));
    }
}