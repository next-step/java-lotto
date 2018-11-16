package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String getCommaLottoNums(List<Integer> lotto){
        return String.join(", ", getLottoNumbersToStringArray(lotto));
    }

    public static String[] getLottoNumbersToStringArray(List<Integer> numbers){
        String[] lottoNums = new String[LottoMaker.NUM_OF_NUMBERS];
        for(int i = 0 ; i < numbers.size() ; i++ ){
            lottoNums[i] = String.valueOf(numbers.get(i));
        }
        return lottoNums;
    }

    public static List<Integer> getIntListFromString(String nums){
        return Arrays.stream(nums.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static double getProfit(int sum, int money) {
        return sum/money;
    }
}
