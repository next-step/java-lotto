import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class StringCalculator {
    /**
     * 입력 값을 전달받아 덧셈을 한다.
     * 연산시 문자를 구분하는 값은 ",", ":" 이다.
     * @param text
     * @return
     */
    public static int calculate(String text) {
        if (text == null || text.isEmpty())
            return 0;

        String[] values = text.split(",|:");

        if (values.length == 1)
            return Integer.parseInt(values[0]);

        AtomicInteger result = new AtomicInteger(Integer.parseInt(values[0]));
        String[] otherValues = Arrays.copyOfRange(values, 1, values.length);;

        IntStream.range(0, otherValues.length)
                .forEach(index -> result.addAndGet(Integer.parseInt(otherValues[index])));

        return result.get();
    }
}
