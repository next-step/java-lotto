package lotto;

import lotto.model.CandidateLotto;
import lotto.strategy.DrawingStrategy;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTest {
    @Test
    public void 중복된_로또_번호_체크() throws Exception {

        int numberCount = getNumberCount();

        SortedSet<Integer> testNumbers = testNumbers(numberCount, e -> 1);
        assertThatIllegalArgumentException().isThrownBy(() ->new CandidateLotto(new ManualStrategy(testNumbers)));

    }

    @Test
    public void 임계치를_벗어난_로또_체크() throws Exception {
        int numberCount = getNumberCount();
        int threshold = getThreshold();

        SortedSet<Integer> testNumbers = testNumbers(numberCount, e -> threshold + e);

        assertThatIllegalArgumentException().isThrownBy(() ->new CandidateLotto(new ManualStrategy(testNumbers)));
    }

    @Test
    public void 정상_로또_체크() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        SortedSet<Integer> testNumbers = testNumbers(numberCount, e -> threshold - e);

        assertThat(new CandidateLotto(new ManualStrategy(testNumbers))).isNotNull();
    }

    @Test
    public void 일등_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        SortedSet<Integer> manualNumbers = testNumbers(numberCount, e -> threshold - e);

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(manualNumbers, 0).size()).isEqualTo(numberCount);

    }

    @Test
    public void 부분_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        SortedSet<Integer> manualNumbers = testNumbers(numberCount, e -> e + 1);
        SortedSet<Integer> winnerNumbers = testNumbers(numberCount, e -> e + 1);

        winnerNumbers.remove(1);
        winnerNumbers.add(threshold);

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(winnerNumbers, 0).size()).isEqualTo(numberCount - 1);

    }


    private SortedSet<Integer> testNumbers(int numberCount, IntUnaryOperator mapper) {
        return IntStream.range(0, numberCount)
                .map(mapper)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));
    }


    private int getNumberCount() throws Exception {
        Field lottoField =  DrawingStrategy.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        return lottoField.getInt(CandidateLotto.class);
    }

    private int getThreshold() throws Exception {
        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        return drawingField.getInt(DrawingStrategy.class);
    }

}
