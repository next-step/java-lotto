package step2.service;

import step2.domain.Lottos;

public class LottoGameService {
    private static final int REWARD_4TH = 5000;
    private static final int REWARD_3RD = 50000;
    private static final int REWARD_2ND = 1500000;
    private static final int REWARD_1ST = 2000000000;

    public LottoGameService(Lottos lottos, String numbers) {
        lottos.matching(numbers);
    }


    public void result() {
    }
}
