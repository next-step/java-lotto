package lotto.domain.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 임의의_로또_생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 임의의_로또_정렬_후_생성() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 2, 4, 6);

        Lotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_숫자_매치_카운트_3개_일치() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.checkMatchNumbers(lotto)).isEqualTo(3);
    }

    @Test
    public void 로또_숫자_매치_카운트_6개_일치() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.checkMatchNumbers(lotto)).isEqualTo(6);
    }

    @Test
    public void 보너스볼_포함_여부_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 10);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertTrue(winningLotto.checkBonusNumber(lotto));
    }
}
