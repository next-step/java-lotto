package im.juniq.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {

    private final Price price;
    private final ShuffleStrategy shuffleStrategy;
    private final List<LottoNumbers> manualLottoes;

    private LotteryMachine(Price price, List<LottoNumbers> manualLottoes, ShuffleStrategy shuffleStrategy) {
        this.price = price;
        this.shuffleStrategy = shuffleStrategy;
        this.manualLottoes = manualLottoes;
    }

    public static LotteryMachine of(Price price, List<LottoNumbers> manualLottoes) {
        return new LotteryMachine(price, manualLottoes, new NormalShuffleStrategy());
    }

    public static LotteryMachine of(int price, List<LottoNumbers> manualLottoes, ShuffleStrategy shuffleStrategy) {
        return new LotteryMachine(Price.from(price), manualLottoes, shuffleStrategy);
    }

    public static LotteryMachine of(int price, ShuffleStrategy shuffleStrategy) {
        return new LotteryMachine(Price.from(price), new ArrayList<>(), shuffleStrategy);
    }

    public Lottoes lottoes() {
        return Lottoes.of(this.price.numberOfLottoPurchased(), shuffleStrategy, manualLottoes);
    }

    public Price price() {
        return price;
    }
}
