package step2.utils;

import step2.LottoNumberGenerator;
import step2.exceptions.DuplicationLottoNumbers;
import step2.exceptions.OutOfLottoNumberRange;

import java.util.HashSet;
import java.util.List;

public class ValidationUtils {
    public static void validationNumbers(List<Integer> numbers){
        if(numbers.size()>6){
            //throw new RuntimeException("번호가 6개를 초과하였습니다.");
            throw new OutOfLottoNumberRange("번호가 6개를 초과하였습니다.");
        }
        if(isNotRangeOfLottoNumbers(numbers)){
            // throw new RuntimeException("로또 번호 범위를 벗어났습니다.");
            throw new OutOfLottoNumberRange("로또 번호 범위를 벗어났습니다.");
        }
        HashSet<Integer> hashSet = new HashSet<>(numbers);
        if(hashSet.size()!= numbers.size()){
            // throw new RuntimeException("중복된 번호가 있습니다.");
            throw new DuplicationLottoNumbers();
        }
    }

    private static boolean isNotRangeOfLottoNumbers(List<Integer> numbers){
        boolean bool = false;
        if(whichSmallestNumber(numbers)< LottoNumberGenerator.lottoMinNumber || whichBigNumbers(numbers)>LottoNumberGenerator.lottoMaxNumber){
            bool = true;
        }
        return bool;
    }

    private static int whichSmallestNumber(List<Integer> list){
        int min = list.get(0);
        for (Integer integer : list) {
            if(min>integer){
                min = integer;
            }
        }
        return min;
    }

    private static int whichBigNumbers(List<Integer> list){
        int max = list.get(0);
        for (Integer integer : list) {
            if(max<integer){
                max = integer;
            }
        }
        return max;
    }
}
