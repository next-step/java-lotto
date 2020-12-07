package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {
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
        LottoNumber lottoNumber = lottoNumberCache.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 번호 범위 벗어남");
        }
        return lottoNumber;
    }

    public int getNumber() {
        return this.number;
    }

    public static List<LottoNumber> getLottoNumbers() {
        return lottoNumbersCache;
    }
}
