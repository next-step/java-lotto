package lotto.domain;

import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final String NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 {0}에서 {1}사이 숫자 입니다.";
    private static final Map<Integer, LottoNumber> lottoNumbers;

    private int number;

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    static {
        lottoNumbers = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed().collect(Collectors.toMap(key -> key, value -> new LottoNumber(value)));
    }

    public LottoNumber() {
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber generate(int number) {
        if(checkLottoNumber(number)){
            String msg = MessageFormat.format(NUMBER_RANGE_ERROR_MESSAGE, LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            throw new IllegalArgumentException(msg);
        };
        return lottoNumbers.get(number);
    }

    private static boolean checkLottoNumber(int number) {
        if(number >= LOTTO_START_NUMBER || number <= LOTTO_END_NUMBER) {
            return true;
        }
        return false;
    }
}
