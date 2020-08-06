import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {

    public StringCalculator() {
    }

    /**
     * 입력 값을 전달받아 덧셈을 한다.
     * 연산시 문자를 구분하는 값은 ",", ":" 이다.
     *
     * @param text
     * @return
     */
    public static int calculate(String text) {
        if (text == null || text.isEmpty())
            return 0;

        String[] values = parse(text);

        valid(values);

        if (values.length == 1)
            return Integer.parseInt(values[0]);

        AtomicInteger result = new AtomicInteger(Integer.parseInt(values[0]));
        String[] otherValues = Arrays.copyOfRange(values, 1, values.length);

        IntStream.range(0, otherValues.length)
                .forEach(index -> result.addAndGet(Integer.parseInt(otherValues[index])));

        return result.get();
    }

    /**
     * 문자열 값의 유효성을 확인한다.
     *
     * @param values
     */
    private static void valid(String[] values) {
        Arrays.stream(values)
                .forEach(value -> {
                    if (Integer.parseInt(value) < 0)
                        throw new RuntimeException("음수는 계산 할 수 없습니다.");
                });
    }

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGX = "//(.)\n(.*)";

    /**
     * 문자열 분석해 계산 할 수 있는 문자열로 반환한다.
     *
     * @param text
     * @return
     */
    private static String[] parse(String text) {
        String[] result;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGX).matcher(text);

        if (!matcher.find()) {
            result = text.split(DEFAULT_DELIMITER);
            return result;
        }

        String customDelimiter = matcher.group(1);
        result = matcher.group(2).split(customDelimiter);

        return result;
    }
}
