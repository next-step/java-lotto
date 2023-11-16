package step3.domain;

import step3.cache.LottoNumberCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    public static final int NUMBER_BOX_START_NUMBER = 1;
    public static final int NUMBER_BOX_END_NUMBER = 45;

    private final int number;

    public static LottoNumber of(int number) {
        if(LottoNumberCache.getLottoNumber(number) != null){
            return LottoNumberCache.getLottoNumber(number);
        }
        return new LottoNumber(number);
    }

    private LottoNumber(int number) {
        inputValidation(number);
        this.number = number;
    }

    private void inputValidation(int number) {
        if (number < NUMBER_BOX_START_NUMBER || number > NUMBER_BOX_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자만 가능합니다.");
        }
    }

    public int number() {
        return number;
    }


    static class LottoNumberCache {

        private static final Map<Integer, LottoNumber> LottoNumberCache = new HashMap<>();

        static {
            for (int i = NUMBER_BOX_START_NUMBER; i <= NUMBER_BOX_END_NUMBER; i++) {
                LottoNumberCache.put(i, LottoNumber.of(i));
            }
        }

        public static LottoNumber getLottoNumber(int number) {
            return LottoNumberCache.getOrDefault(number, LottoNumber.of(number));
        }
    }

}
