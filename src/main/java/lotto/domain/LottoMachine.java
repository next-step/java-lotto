package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoMachine {

    private static final int LOTTO_PRICE = 1_000;

    private LottoMachine() {
        throw new IllegalCallerException("잘못되 객체생성 입니다.");
    }

    public static List<List<Integer>> issue(int cache) {
        int availableLottoCount = cache / LOTTO_PRICE;
        return issueLotto(availableLottoCount);
    }

    private static List<List<Integer>> issueLotto(int availableLottoCount) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < availableLottoCount; i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }

}