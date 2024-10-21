package lotto.service;

import java.util.List;

public class LottoSeller {

    private LottoSeller() {
    }

    public static List<Integer> sellLotto() {
        return LottoGenerator.generateLotto();
    }

}
