package lotto.domain.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        Lotto winningLotto = new WinningLotto(numbers);
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

        Lotto winningLotto = new WinningLotto(numbers);
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
