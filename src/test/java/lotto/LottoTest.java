package lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 일치하는_번호_개수_구하기() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(i + 1);
        }
        Lotto lotto = new Lotto(numbers);
        Lotto luckyNumbers = new Lotto(numbers);

        int matchCount = lotto.matchNumbers(luckyNumbers);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void Lotto_숫자개수_검증() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(i + 1);
        }
        Lotto lotto = new Lotto(numbers);
    }
}
