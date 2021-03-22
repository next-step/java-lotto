package Calculator;

import java.util.Arrays;

public class StringUtils {

    public static boolean checkEmpty(String input) {
        if (input == null || input.isEmpty() || input.equals("")) {
            return true;
        }
        return false;
    }

    public static int[] parseOperand(String[] strOperands){
        return Arrays.stream(strOperands)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
