import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
    public static String SEPARATOR = "[,:]";
    public static String IS_NUMBER = "[0-9]";
    public static int CUSTOM_LETTER_INDEX = 2;

    public List<String> makeNumbers(String expression) {
        return Arrays.asList(expression.split(SEPARATOR));
    }

    public Boolean isCustomInput(String expression) {
        String[] inputs = expression.split("");
        if(inputs[0] == IS_NUMBER){
            return false;
        }
        return true;
    }

    public ArrayList<String> customSeparate(String customExpression) {
        ArrayList<String> numbers = new ArrayList<>();
        String[] inputs = customExpression.split("");
        for(int i = 0 ; i < inputs.length; i++) {
            numbers.add(inputs[i]);
        }
        return numbers;
    }

    public String findCustomSeparator(String customExpression) {
        return customSeparate(customExpression).get(CUSTOM_LETTER_INDEX);
    }
}
