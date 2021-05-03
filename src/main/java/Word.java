import java.util.ArrayList;
import java.util.List;

public class Word {
    public static String SEPERATOR = "[,:]";

    public List<String> makeNumbers(String input) {
        ArrayList<String> numbers = new ArrayList<>();
        String[] splitInput = input.split(SEPERATOR);
        numbers.add(splitInput[0]);
        numbers.add(splitInput[1]);
        return numbers;
    }
}
