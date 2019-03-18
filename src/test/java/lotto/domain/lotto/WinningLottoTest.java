package lotto.domain.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 임의의_로또_생성() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Lotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 임의의_로또_정렬_후_생성() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);

        Lotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_숫자_매치_카운트_3개_일치() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(7);
        numbers.add(8);
        numbers.add(9);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.checkMatchNumbers(lotto)).isEqualTo(3);
    }

    @Test
    public void 로또_숫자_매치_카운트_6개_일치() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertThat(winningLotto.checkMatchNumbers(lotto)).isEqualTo(6);
    }

    @Test
    public void 보너스볼_포함_여부_확인() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(10);
        BasicLotto lotto = new BasicLotto(numbers);

        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        WinningLotto winningLotto = new WinningLotto(numbers, 10);
        assertTrue(winningLotto.checkBonusNumber(lotto));
    }
}
