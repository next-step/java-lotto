package lotto.utile;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsNumber {

    public static int[] shuffleNumber(int[] allLottoNumbers) {
        Integer[] integerNumbers = convertIntToInteger(allLottoNumbers);

        Collections.shuffle(Arrays.asList(integerNumbers));

        int[] intNumbers = convertIntegerToInt(integerNumbers);

        return intNumbers;
    }

    public static void sortArrayNumber(int[] pickLottoNumbers) {
        Arrays.sort(pickLottoNumbers);
    }

    public static Integer[] convertIntToInteger(int[] number){
        Integer[] integers = new Integer[number.length];
        for (int i = 0; i < number.length; i++) {
            integers[i] = Integer.valueOf(number[i]);
        }
        return integers;
    }

    public static int[] convertIntegerToInt(Integer[] number){
        int[] ints = new int[number.length];
        for (int i = 0; i < number.length; i++) {
            ints[i] = number[i];
        }
        return ints;
    }
}
