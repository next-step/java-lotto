import java.util.Arrays;
import java.util.List;

public class Splitters {
    public static final String DELIMITER = "|";
    private final List<String> splitters = Arrays.asList(",", ":");


    public String getRegex() {
        return String.join(DELIMITER, splitters);
    }
}
