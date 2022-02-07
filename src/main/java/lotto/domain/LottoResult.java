package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    private final HashMap<String, Integer> resultMap = new HashMap<String, Integer>() {{
        put(LottoDescription.MATCH3.getHash(), 0);
        put(LottoDescription.MATCH4.getHash(), 0);
        put(LottoDescription.MATCH5.getHash(), 0);
        put(LottoDescription.MATCHBONUS.getHash(), 0);
        put(LottoDescription.MATCH6.getHash(), 0);
    }};

    public int getCount(String hash) {
        return resultMap.get(hash);
    }

    public void upCount(String hash) {
        if (hash != LottoDescription.NOMATCH.getHash()) {
            resultMap.put(hash, resultMap.get(hash) + 1);
        }
    }

}
