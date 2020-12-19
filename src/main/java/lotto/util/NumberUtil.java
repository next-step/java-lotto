package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberUtil {

    private final static int lottoStartNumber = 1;
    private final static int lottoEndNumber = 45;
    private final static String MINUS_VALUE_ERROR="음수는 입력될 수 없습니다.";
    private final static List<Integer> lottoNumbers;
    public static long stringTolong(String number) {
        long parseInt = Long.parseLong(number);
        if (parseInt < 0) {
            throw new RuntimeException(MINUS_VALUE_ERROR);
        }
        return parseInt;
    }

    static {
        lottoNumbers = new ArrayList<>();
        IntStream.rangeClosed(lottoStartNumber, lottoEndNumber)
                .boxed().distinct().forEach(lottoNumbers::add);
    }
    public static List<Integer> getLottoNumbers(){
        return lottoNumbers;
    }
}
