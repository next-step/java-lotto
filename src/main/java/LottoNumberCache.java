import java.util.HashMap;
import java.util.Map;

public class LottoNumberCache {
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber get(String numStr) {
        return get(Integer.parseInt(numStr));
    }

    public static LottoNumber get(int num) {
        if (!cache.containsKey(num)) {
            throw new IllegalArgumentException(num + " is not a lotto number");
        }

        return cache.get(num);
    }
}
