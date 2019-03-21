package lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    @Test
    public void 일치하는_번호_개수_구하기() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(i + 1);
        }
        MyLotto myLotto = new MyLotto(numbers);
        LuckyLotto luckyLotto = new LuckyLotto(numbers, 7);

        int matchCount = myLotto.matchNumbers(luckyLotto);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test(expected = RuntimeException.class)
    public void Lotto_숫자개수_검증() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(i + 1);
        }
        MyLotto myLotto = new MyLotto(numbers);
    }

    @Test
    public void 보너스당첨_확인() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> luckyNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            luckyNumbers.add(i);
            numbers.add(i+1);
        }
        MyLotto myLotto = new MyLotto(numbers);
        LuckyLotto luckyLotto = new LuckyLotto(luckyNumbers, 7);
        myLotto.matchNumbers(luckyLotto);
        assertThat(myLotto.getMatchBonus()).isEqualTo(true);
    }
}
