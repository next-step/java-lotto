package lotto;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setup() {
        Set<Integer> numbers = new TreeSet<>(Arrays.asList(1, 5, 10, 22, 35, 40));
        lotto = new Lotto(numbers);
    }

    @Test
    public void 로또번호비교하기() {
        Set<Integer> winningNumber = new TreeSet<>(Arrays.asList(2, 5, 11, 23, 35, 40));

        lotto.countbyComparingNumbers(winningNumber);
        LottoType lottoType = lotto.findLottoType();

        assertThat(lottoType).isEqualTo(LottoType.THREE);
    }

    @Test
    public void 당첨로() {
        Set<Integer> winningNumber = new TreeSet<>(Arrays.asList(2, 5, 11, 23, 35, 40));

        lotto.countbyComparingNumbers(winningNumber);
        boolean result = lotto.isWinning();

        assertThat(result).isTrue();
    }
}