package step3.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int number;
    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();
    private static ArrayList<LottoNumber> lottoNumbersCache = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(i -> {
                    LottoNumber lottoNumber = new LottoNumber(i);
                    lottoNumberCache.put(i, lottoNumber);
                    lottoNumbersCache.add(lottoNumber);
                });
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateLottoNumber(number);
        LottoNumber lottoNumber = lottoNumberCache.get(number);
        return lottoNumber;
    }

    private static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            String msg = MessageFormat.format("로또 번호는 {0}에서 {1}사이 숫자 입니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            throw new IllegalArgumentException(msg);
        }
    }

    public int getNumber() {
        return this.number;
    }

    public static List<LottoNumber> getLottoNumbers() {
        return lottoNumbersCache;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
