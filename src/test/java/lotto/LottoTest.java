package lotto;

import lotto.model.Lotto;
import lotto.strategy.AutoDrawing;
import lotto.strategy.DrawingStrategy;
import lotto.strategy.ManualDrawing;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 중복된_로또_번호_체크() throws Exception {
        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);

        Method isInvalid = drawingStrategy.getClass().getDeclaredMethod("isInvalid", List.class, int.class);
        isInvalid.setAccessible(true);

        Field field = Lotto.class.getDeclaredField("NUMBER_COUNT");
        field.setAccessible(true);

        int numberCount = field.getInt(Lotto.class);

        List<Integer> testNumbers = IntStream.range(0, numberCount)
                .map(e -> 1)
                .boxed().collect(Collectors.toList());

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(true);
    }

    @Test
    public void 임계치를_벗어난_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);

        Method isInvalid = drawingStrategy.getClass().getDeclaredMethod("isInvalid", List.class, int.class);
        isInvalid.setAccessible(true);

        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        Field lottoField = Lotto.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        int numberCount = lottoField.getInt(Lotto.class);
        int threshold = drawingField.getInt(DrawingStrategy.class);

        List<Integer> testNumbers = IntStream.range(0, numberCount).map(e -> threshold + e)
                .boxed().collect(Collectors.toList());

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(true);
    }

    @Test
    public void 정상_로또_체크() throws Exception {

        DrawingStrategy drawingStrategy = Mockito.mock(DrawingStrategy.class, Mockito.CALLS_REAL_METHODS);

        Method isInvalid = drawingStrategy.getClass().getDeclaredMethod("isInvalid", List.class, int.class);
        isInvalid.setAccessible(true);

        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        Field lottoField = Lotto.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        int numberCount = lottoField.getInt(Lotto.class);
        int threshold = drawingField.getInt(DrawingStrategy.class);

        List<Integer> testNumbers = IntStream.range(0, numberCount).map(e -> threshold - e)
                .boxed().collect(Collectors.toList());

        assertThat(isInvalid.invoke(drawingStrategy, testNumbers, numberCount)).isEqualTo(false);
    }

    @Test
    public void 일등_로또_매칭_결과() throws Exception {

        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        Field lottoField = Lotto.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        int numberCount = lottoField.getInt(Lotto.class);
        int threshold = drawingField.getInt(DrawingStrategy.class);

        List<Integer> manualNumbers = IntStream.range(0, numberCount).map(e -> threshold - e)
                .boxed().collect(Collectors.toList());

        Lotto testLotto = new Lotto(new ManualDrawing(manualNumbers));

        assertThat(testLotto.getMatchingNumbers(manualNumbers).size()).isEqualTo(numberCount);

    }

    @Test
    public void 부분_로또_매칭_결과() throws Exception {

        Field drawingField = DrawingStrategy.class.getDeclaredField("THRESHOLD");
        drawingField.setAccessible(true);

        Field lottoField = Lotto.class.getDeclaredField("NUMBER_COUNT");
        lottoField.setAccessible(true);

        int numberCount = lottoField.getInt(Lotto.class);
        int threshold = drawingField.getInt(DrawingStrategy.class);

        List<Integer> manualNumbers = IntStream.range(0, numberCount).map(e -> e + 1)
                .boxed().collect(Collectors.toList());

        List<Integer> winnerNumbers = IntStream.range(0, numberCount).map(e -> e + 1)
                .boxed().collect(Collectors.toList());

        winnerNumbers.set(0, threshold);

        Lotto testLotto = new Lotto(new ManualDrawing(manualNumbers));

        assertThat(testLotto.getMatchingNumbers(winnerNumbers).size()).isEqualTo(numberCount - 1);

    }
}
