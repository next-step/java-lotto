import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tokenizer {

    public static List<Integer> split(String message) {
        List<Integer> result = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(message, ",|:");
        while (stringTokenizer.hasMoreTokens()) {
            result.add(Integer.valueOf(stringTokenizer.nextToken()));
        }
        return result;
    }
}
