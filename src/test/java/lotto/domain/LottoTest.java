package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.utils.LottoNumberGenerator.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private List<LottoNo> numbers;

    @Before
    public void setup() {
        numbers = generate(1, 10, 15, 20, 25, 30);
    }

    @Test
    public void 랜덤으로_로또를_생성할수있다() {
        Lotto lotto = Lotto.create();
        assertThat(lotto).isNotNull();
    }

    @Test
    public void 로또숫자목록으로_로또를_생성할수있다() {
        Lotto lotto = Lotto.create(numbers);
        assertThat(lotto).isNotNull();
    }

    @Test
    public void 일치하는_로또숫자가_존재하는지_알수있다() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 10, 15, 91, 92, 93));

        Lotto lotto = Lotto.create(numbers);
        assertThat(lotto.hasMatches(winningLotto.getNumbers(), 3)).isTrue();
    }

    @Test
    public void 일치하는_로또숫자_갯수를_알수있다() {
        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 10, 15, 91, 92, 93));

        Lotto lotto = Lotto.create(numbers);
        assertThat(lotto.numberOfMatches(winningLotto.getNumbers())).isEqualTo(3);
    }
}