import java.util.ArrayList;
import java.util.List;

public class Word {
    public static String SEPARATOR = "[,:]";
    public static String IS_NUMBER = "[0-9]";

    public List<String> makeNumbers(String input) {
        ArrayList<String> numbers = new ArrayList<>();
        String[] inputs = input.split(SEPARATOR);
        numbers.add(inputs[0]);
        numbers.add(inputs[1]);
        return numbers;
    }

    public Boolean isCustomInput(String input) {
        String[] inputs = input.split("");
        if(inputs[0] == IS_NUMBER){
            return false;
        }
        return true;
    }
}
