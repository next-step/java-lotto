package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    private final HashMap<String, Integer> resultMap = new HashMap<String, Integer>() {{
        LottoDescription.toList()
            .forEach(lottoDescription -> put(lottoDescription.getHash(), 0));
    }};

    public int getCount(String hash) {
        return resultMap.get(hash);
    }

    public void raffle(WinningLotto winningLotto, Lottoes lottoes) {
        for (Lotto lotto : lottoes.getLottos()) {
            String resultHash = winningLotto.compareLotto(lotto);
            upCount(resultHash);
        }
    }

    public void upCount(String hash) {
        if (!hash.equals(LottoDescription.NOMATCH.getHash())) {
            resultMap.put(hash, resultMap.get(hash) + 1);
        }
    }

}
