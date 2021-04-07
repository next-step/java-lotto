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

    public static LotteryMachine withManualNumbers(int price, List<LottoNumbers> manualLottoes, ShuffleStrategy shuffleStrategy) {
        return new LotteryMachine(Price.of(price), manualLottoes, shuffleStrategy);
    }

    public static LotteryMachine withManualNumbers(Price price, List<LottoNumbers> manualLottoes) {
        return new LotteryMachine(price, manualLottoes, new NormalShuffleStrategy());
    }

    public static LotteryMachine withPrice(int price, ShuffleStrategy shuffleStrategy) {
        return new LotteryMachine(Price.of(price), new ArrayList<>(), shuffleStrategy);
    }

    public Lottoes lottoes() {
        return new Lottoes(this.price.numberOfLottoPurchased(), shuffleStrategy, manualLottoes);
    }

    public Price price() {
        return price;
    }
}
