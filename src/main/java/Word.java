import java.util.ArrayList;
import java.util.List;

public class Word {
    public static String SEPARATOR = "[,:]";

    public List<String> makeNumbers(String input) {
        ArrayList<String> numbers = new ArrayList<>();
        String[] splitInput = input.split(SEPARATOR);
        numbers.add(splitInput[0]);
        numbers.add(splitInput[1]);
        return numbers;
    }
}
