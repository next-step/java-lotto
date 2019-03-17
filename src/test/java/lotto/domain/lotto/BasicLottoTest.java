package lotto.domain.lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicLottoTest {

    private List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
    }

    @Test
    public void 임의의_로또_생성() {
        Lotto lotto = new BasicLotto(numbers);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또_매치카운트_증가() {
        BasicLotto lotto = new BasicLotto(numbers);
        assertThat(lotto.matchCountUp()).isEqualTo(1);
    }
}
