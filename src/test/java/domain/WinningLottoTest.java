package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private static final String[] WINNING_NUMBERS = new String[]{"1","2","3","4","5","6"};
    private static final int BONUS_NUMBER = 7;
    private WinningLotto winningLotto;

    @Before
    public void SET_UP() {
        winningLotto = new WinningLotto(WINNING_NUMBERS, BONUS_NUMBER);
    }

    public Lotto makeLottoInstance(List<Integer> inputNumbers) {
        List<Number> numbers = new ArrayList<>();
        for( int number : inputNumbers) {
            numbers.add(Number.createInstance(number));
        }

        return new Lotto(LottoNumbers.createInstance(inputNumbers));
    }
    @Test
    public void 당첨번호에_따른_상태_확인_당첨X() {
        List<Integer> inputNumbers = Arrays.asList(1,7,8,9,10,11);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.NONE);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_3개_일치() {
        List<Integer> inputNumbers = Arrays.asList(1,2,3,9,10,11);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.WINNING_NUM_3);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_4개_일치() {
        List<Integer> inputNumbers = Arrays.asList(1,2,3,4,10,11);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.WINNING_NUM_4);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_5개_일치() {
        List<Integer> inputNumbers = Arrays.asList(1,2,3,4,5,11);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.WINNING_NUM_5);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_5개_일치_보너스번호_일치() {
        List<Integer> inputNumbers = Arrays.asList(1,2,3,4,5,7);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.WINNING_NUM_5_BONUS);
    }

    @Test
    public void 당첨번호에_따른_상태_확인_6개_일치() {
        List<Integer> inputNumbers = Arrays.asList(1,2,3,4,5,6);
        assertThat(winningLotto.result(makeLottoInstance(inputNumbers))).isEqualTo(LottoResultStatus.WINNING_NUM_6);
    }
}
