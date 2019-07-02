package camp.nextstep.edu.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleLotteryService implements LotteryService {

    private static final int ZERO = 0;

    @Override
    public Lotteries purchase(int investment) {
        final NaturalNumber naturalNumberInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfLotteries = naturalNumberInvestment.divideBy(Lottery.PRICE);
        final int numberOfLotteries = naturalNumberOfLotteries.value();
        final List<Lottery> lotteryList = IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
        return Lotteries.from(lotteryList);
    }

    @Override
    public void validate(int investment, int numberOfCustomizedLotteries) {
        final NaturalNumber naturalInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfCustomizedLotteries = NaturalNumber.from(numberOfCustomizedLotteries);

        final NaturalNumber availableNumberOfLotteries = Lottery.getAvailableNumberOfLotteries(naturalInvestment);
        if (availableNumberOfLotteries.isLessThan(naturalNumberOfCustomizedLotteries)) {
            throw new IllegalArgumentException("'numberOfCustomizedLotteries' must be less than or equal to (investment / " + Lottery.PRICE + ")");
        }
    }

    public Lotteries purchase(int investment, List<List<Integer>> numbers) {
        final NaturalNumber naturalNumberInvestment = NaturalNumber.from(investment);
        final NaturalNumber naturalNumberOfLotteries = Lottery.getAvailableNumberOfLotteries(naturalNumberInvestment);

        final int numberOfCustomizedLotteries = numbers.size();
        final NaturalNumber naturalNumberOfCustomizedLotteries = NaturalNumber.from(numberOfCustomizedLotteries);
        final NaturalNumber naturalNumberOfRandomizedLotteries = naturalNumberOfLotteries.subtract(naturalNumberOfCustomizedLotteries);

        final List<Lottery> customizedLotteries = this.createCustomizedLotteries(numbers);
        final List<Lottery> randomizedLotteries = this.createRandomizedLotteries(naturalNumberOfRandomizedLotteries);

        final List<Lottery> lotteryList = new ArrayList<>();
        lotteryList.addAll(customizedLotteries);
        lotteryList.addAll(randomizedLotteries);

        return Lotteries.from(lotteryList);
    }

    private List<Lottery> createRandomizedLotteries(NaturalNumber naturalNumberOfLotteries) {
        final int numberOfLotteries = naturalNumberOfLotteries.value();
        return IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> Lottery.randomizedInstance())
                .collect(Collectors.toList());
    }

    private List<Lottery> createCustomizedLotteries(List<List<Integer>> listOfNumbers) {
        return listOfNumbers.stream()
                .map(numberSet -> {
                    Set<LotteryNumber> lotteryNumberSet = numberSet.stream()
                            .map(LotteryNumber::from)
                            .collect(Collectors.toSet());
                    return Lottery.customizedInstance(lotteryNumberSet);
                })
                .collect(Collectors.toList());
    }

    @Override
    public LotteriesReward getResult(Lotteries purchasedLotteries, Set<Integer> winningNumberSet, Integer bonusNumber) {
        final Set<LotteryNumber> winningLotteryNumberSet = winningNumberSet.stream()
                .map(LotteryNumber::from)
                .collect(Collectors.toSet());
        final Lottery lottery = Lottery.customizedInstance(winningLotteryNumberSet);
        final LotteryNumber bonusLotteryNumber = LotteryNumber.from(bonusNumber);
        final WinningLottery winningLottery = WinningLottery.of(lottery, bonusLotteryNumber);
        return this.resolveRewards(purchasedLotteries, winningLottery);
    }

    private LotteriesReward resolveRewards(Lotteries purchasedLotteries, WinningLottery winningLottery) {
        final List<RewardType> rewardTypes = purchasedLotteries.stream()
                .map(winningLottery::resolveReward)
                .collect(Collectors.toList());
        return LotteriesReward.from(rewardTypes);
    }

    @Override
    public double calculateEarningsRate(int investment, LotteriesReward lotteriesReward) {
        final double reward = lotteriesReward.sumAllRewards();
        return this.resolveEarningRate(investment, reward);
    }

    private double resolveEarningRate(int investment, double reward) {
        if (investment <= ZERO) {
            throw new IllegalArgumentException("'investment' must be greater than " + ZERO);
        }
        if (reward < ZERO) {
            throw new IllegalArgumentException("'reward' must be greater than or equal to " + ZERO);
        }
        return reward / (double) investment;
    }
}
