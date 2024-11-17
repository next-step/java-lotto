package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNumberCache {
    private static final LottoNumberCache INSTANCE = new LottoNumberCache();
    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    private LottoNumberCache() {
    }

    static LottoNumberCache getInstance() {
        return INSTANCE;
    }

    Optional<LottoNumber> find(Integer key) {
        return Optional.ofNullable(cache.get(key));
    }

    void add(int key, LottoNumber value) {
        cache.put(key, value);
    }
}
