import java.util.HashMap;
import java.util.Map;

public class LottoNumberCache {
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    public static LottoNumber get(String numStr) {
        return get(Integer.parseInt(numStr));
    }

    public static LottoNumber get(int num) {
        if (!cache.containsKey(num)) {
            cache.put(num, new LottoNumber(num));
        }

        return cache.get(num);
    }
}
