import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final String NEGATIVE_NUMBER_ERROR = "음수는 계산할 수 없습니다.";
    private static final String STRING_MESSAGE_ERROR = "문자열은 계산할 수 없습니다.";

    public static List<Integer> split(String message) {
        return split(message, DEFAULT_DELIMITERS);
    }

    public static List<Integer> split(String message, String delimiter) {
        List<Integer> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(message, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            result.add(validateToken(stringTokenizer.nextToken()));
        }
        return  result;
    }

    private static int validateToken(String token) {
        int result;
        try {
            result = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(STRING_MESSAGE_ERROR);
        }
        if (result <= -1) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR);
        }
        return result;
    }

}
