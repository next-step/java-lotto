import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public static List<Integer> split(String message) {
        List<Integer> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(message, ",|:");
        while (stringTokenizer.hasMoreTokens()) {
            result.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return result;
    }

    public static List<Integer> split(String message, String delimiter) {
        List<Integer> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(message, delimiter);
        while (stringTokenizer.hasMoreTokens()) {
            result.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return  result;
    }
}
