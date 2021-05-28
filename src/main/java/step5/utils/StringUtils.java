package step5.utils;

import java.util.*;

public class StringUtils {
    private static final String SEPARATOR = ",";

    private StringUtils(){
        throw new AssertionError();
    }

    public static Set<Integer> processStringNumbers(String numberString){
        String[] splitString = splitString(numberString);
        return changeStringToLottoNumbers(splitString);
    }

    private static String[] splitString(String numberString) {
        return numberString.split(SEPARATOR);
    }

    private static Set<Integer> changeStringToLottoNumbers(String[] winningNumbers) {
        Set<Integer> winningNumberSet = new TreeSet<>();
        for (int i = 0; i < winningNumbers.length; i++) {
            winningNumberSet.add(Integer.parseInt(winningNumbers[i]));
        }
        return winningNumberSet;
    }
}
