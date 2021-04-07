package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

    private final Price price;
    private final ShuffleStrategy shuffleStrategy;
    private final List<LottoNumbers> manualLottoes;

    public LotteryMachine(int price, ShuffleStrategy shuffleStrategy) {
        this(new Price(price), shuffleStrategy);
    }

    public LotteryMachine(Price price, ShuffleStrategy shuffleStrategy) {
        this.price = price;
        this.shuffleStrategy = shuffleStrategy;
        this.manualLottoes = new ArrayList<>();
    }

    public LotteryMachine(Price price, List<LottoNumbers> manualLottoes) {
        this(price, manualLottoes, new NormalShuffleStrategy());
    }

    public LotteryMachine(Price price, List<LottoNumbers> manualLottoes, ShuffleStrategy shuffleStrategy) {
        this.price = price;
        this.shuffleStrategy = shuffleStrategy;
        this.manualLottoes = manualLottoes;
    }

    public Lottoes lottoes() {
        return new Lottoes(this.price.numberOfLottoPurchased(), shuffleStrategy, manualLottoes);
    }

    public Price price() {
        return price;
    }
}
