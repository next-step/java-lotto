package lotto.domain;

import lotto.factory.LotteryFactory;

import java.util.ArrayList;

public class ManualLotteryGame extends AbstractLotteryGame {
    private final String lottoNumbers;

    public ManualLotteryGame(String lottoNumbers) {
        super(new ArrayList<>());
        this.lottoNumbers = lottoNumbers;
        create();
    }

    void create() {
        lotteries = LotteryFactory.create(lottoNumbers);
    }
}
