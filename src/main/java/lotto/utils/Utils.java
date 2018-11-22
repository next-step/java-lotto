package lotto.utils;

import lotto.dto.Lotto;
import lotto.vo.LottoNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    public static String getCommaLottoNums(Set<LottoNum> lotto){
        return String.join(", ", getLottoNumbersToStringArray(lotto));
    }

    public static String[] getLottoNumbersToStringArray(Set<LottoNum> numbers){
        String[] lottoNums = new String[Lotto.LOTTO_SIZE];
        for(int i = 0 ; i < numbers.size() ; i++ ){
            lottoNums[i] = String.valueOf(numbers.toArray()[i]);
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
