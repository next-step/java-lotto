package step3.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private static final String SEPARATOR = ",";

    private StringUtils(){
        throw new AssertionError();
    }

    public static List<Integer> processStringNumbers(String numberString){
        String[] splitString = splitString(numberString);
        return changeStringToLottoNumbers(splitString);

    }

    private static String[] splitString(String numberString) {
        return numberString.split(SEPARATOR);
    }

    private static List<Integer> changeStringToLottoNumbers(String[] winningNumbers) {
        List<Integer> winningNumberList = new ArrayList<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumberList.add(Integer.parseInt(winningNumbers[i]));
        }
        return winningNumberList;
    }
}
