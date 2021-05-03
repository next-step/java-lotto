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

    public ArrayList<String> customSeparate(String input) {
        ArrayList<String> numbers = new ArrayList<>();
        String[] inputs = input.split("");
        for(int i = 0 ; i < inputs.length; i++) {
            numbers.add(inputs[i]);
        }
        return numbers;
    }
}
