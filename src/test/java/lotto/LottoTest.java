package lotto;

import lotto.model.CandidateLotto;
import lotto.strategy.DrawingStrategy;
import lotto.strategy.ManualStrategy;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 중복된_로또_번호_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);
        Method isInvalid = getIsInvalidOfDrawingStrategy(drawingStrategy);

        int numberCount = getNumberCount();

        Set<Integer> testNumbers = testNumbers(numberCount, e -> 1);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers)).isEqualTo(true);
    }

    @Test
    public void 임계치를_벗어난_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);
        Method isInvalid = getIsInvalidOfDrawingStrategy(drawingStrategy);

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        Set<Integer> testNumbers = testNumbers(numberCount, e -> threshold + e);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers)).isEqualTo(true);
    }

    @Test
    public void 정상_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);
        Method isInvalid = getIsInvalidOfDrawingStrategy(drawingStrategy);

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        Set<Integer> testNumbers = testNumbers(numberCount, e -> threshold - e);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers)).isEqualTo(false);
    }

    @Test
    public void 일등_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        Set<Integer> manualNumbers = testNumbers(numberCount, e -> threshold - e);

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(manualNumbers)).isEqualTo(numberCount);

    }

    @Test
    public void 부분_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        Set<Integer> manualNumbers = testNumbers(numberCount, e -> e + 1);
        Set<Integer> winnerNumbers = testNumbers(numberCount, e -> e + 1);

        winnerNumbers.remove(1);
        winnerNumbers.add(threshold);

        CandidateLotto testCandidateLotto = new CandidateLotto(new ManualStrategy(manualNumbers));

        assertThat(testCandidateLotto.getMatchingNumberCount(winnerNumbers)).isEqualTo(numberCount - 1);

    }


    private Set<Integer> testNumbers(int numberCount, IntUnaryOperator mapper) {
        return IntStream.range(0, numberCount)
                .map(mapper)
                .boxed()
                .collect(Collectors.toSet());
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

    private Method getIsInvalidOfDrawingStrategy(DrawingStrategy drawingStrategy) throws Exception {
        Method isInvalid = drawingStrategy.getClass().getDeclaredMethod("isInvalid", Set.class);
        isInvalid.setAccessible(true);

        return isInvalid;
    }


}
