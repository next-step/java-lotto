package lotto.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtil {

    private final static int lottoStartNumber = 1;
    private final static int lottoEndNumber = 45;
    private final static String MINUS_VALUE_ERROR="음수는 입력될 수 없습니다.";
    private final static List<Integer> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(lottoStartNumber, lottoEndNumber)
                .boxed().distinct().forEach(lottoNumbers::add);
    }

    private NumberUtil(){}

    public static long stringToLong(String number) {
        long parseLong = Long.parseLong(number);
        if (parseLong < 0) {
            throw new RuntimeException(MINUS_VALUE_ERROR);
        }
        return parseLong;
    }

    public static List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }

    public static List<Integer> convertStringToIntegerList(String number){
       return Arrays.stream( number.split(","))
                .map(Integer::parseInt).sorted().collect(Collectors.toList());
    }


    public static int convertStringToInteger(String newbonusNumber) {
        int parseInt = Integer.parseInt(newbonusNumber);
        if (parseInt < 0) {
            throw new RuntimeException(MINUS_VALUE_ERROR);
        }
        return parseInt;
    }
}
