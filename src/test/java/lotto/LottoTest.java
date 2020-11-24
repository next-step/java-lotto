package lotto;

import lotto.model.CandidateLotto;
import lotto.model.LottoNumber;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;
import utils.TestUtils;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTest {
    @Test
    public void 중복된_로또_번호_체크() throws Exception {

        int numberCount = TestUtils.getNumberCount();

        SortedSet<LottoNumber> testNumbers = testNumbers(numberCount, e -> new LottoNumber(1));
        assertThatIllegalArgumentException().isThrownBy(() ->new CandidateLotto(new ManualStrategy(testNumbers)));

    }


    @Test
    public void 정상_로또_체크() throws Exception {

        int numberCount = TestUtils.getNumberCount();
        int threshold = TestUtils.getThreshold();

        SortedSet<LottoNumber> testNumbers = testNumbers(numberCount, e -> new LottoNumber(threshold - e));

        assertThat(new CandidateLotto(new ManualStrategy(testNumbers))).isNotNull();
    }

    @Test
    public void 일등_로또_매칭_결과() throws Exception {

        int numberCount = TestUtils.getNumberCount();
        int threshold = TestUtils.getThreshold();

        SortedSet<LottoNumber> manualNumbers = testNumbers(numberCount, e -> new LottoNumber(threshold - e));

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(manualNumbers, new LottoNumber(13)).size()).isEqualTo(numberCount);

    }

    @Test
    public void 부분_로또_매칭_결과() throws Exception {

        int numberCount = TestUtils.getNumberCount();
        int threshold = TestUtils.getThreshold();

        SortedSet<LottoNumber> manualNumbers = testNumbers(numberCount, e -> new LottoNumber(e+1));
        SortedSet<LottoNumber> winnerNumbers = testNumbers(numberCount, e ->  new LottoNumber(e+1));

        winnerNumbers.remove(new LottoNumber(1));
        winnerNumbers.add(new LottoNumber(threshold));

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(winnerNumbers, new LottoNumber(13)).size()).isEqualTo(numberCount - 1);

    }


    private SortedSet<LottoNumber> testNumbers(int numberCount, IntFunction<LottoNumber> mapper) {
        return IntStream.range(0, numberCount)
                .mapToObj(mapper)
                .collect(Collectors.toCollection(TreeSet::new));
    }

}
