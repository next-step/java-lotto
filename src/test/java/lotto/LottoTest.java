package lotto;

import lotto.model.Lotto;
import lotto.strategy.DrawingStrategy;
import lotto.strategy.ManualDrawing;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
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

        List<Integer> testNumbers = testNumbers(numberCount, e -> 1);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(true);
    }

    @Test
    public void 임계치를_벗어난_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);
        Method isInvalid = getIsInvalidOfDrawingStrategy(drawingStrategy);

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        List<Integer> testNumbers = testNumbers(numberCount, e -> threshold + e);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(true);
    }

    @Test
    public void 정상_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);
        Method isInvalid = getIsInvalidOfDrawingStrategy(drawingStrategy);

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        List<Integer> testNumbers = testNumbers(numberCount, e -> threshold - e);

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(false);
    }

    @Test
    public void 일등_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        List<Integer> manualNumbers = testNumbers(numberCount, e -> threshold - e);

        Lotto testLotto = new Lotto(new ManualDrawing(manualNumbers));

        assertThat(testLotto.getMatchingNumberCount(manualNumbers)).isEqualTo(numberCount);

    }

    @Test
    public void 부분_로또_매칭_결과() throws Exception {

        int numberCount = getNumberCount();
        int threshold = getThreshold();

        List<Integer> manualNumbers = testNumbers(numberCount, e -> e + 1);
        List<Integer> winnerNumbers = testNumbers(numberCount, e -> e + 1);

        winnerNumbers.set(0, threshold);

        Lotto testLotto = new Lotto(new ManualDrawing(manualNumbers));

        assertThat(testLotto.getMatchingNumberCount(winnerNumbers)).isEqualTo(numberCount - 1);

    }


    private List<Integer> testNumbers(int numberCount, IntUnaryOperator mapper) {
        return IntStream.range(0, numberCount)
                .map(mapper)
                .boxed()
                .collect(Collectors.toList());
    }


    private int getNumberCount() throws Exception {
        Field lottoField = Lotto.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        return lottoField.getInt(Lotto.class);
    }

    private int getThreshold() throws Exception {
        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        return drawingField.getInt(DrawingStrategy.class);
    }

    private Method getIsInvalidOfDrawingStrategy(DrawingStrategy drawingStrategy) throws Exception {
        Method isInvalid = drawingStrategy.getClass().getDeclaredMethod("isInvalid", List.class, int.class);
        isInvalid.setAccessible(true);

        return isInvalid;
    }


}
