package camp.nextstep.edu.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleLotteryService implements LotteryService {

    private static final int ZERO = 0;

    @Override
    public void validate(int investment, int numberOfCustomizedLotteries) {
        final int availableNumberOfLotteries = LotteryPrice.calculateAvailableLottery(investment);
        if (availableNumberOfLotteries < numberOfCustomizedLotteries) {
            throw new IllegalArgumentException("'numberOfCustomizedLotteries' must be less than or equal to (investment / " + LotteryPrice.intValue() + ")");
        }
    }

    public Lotteries purchase(int investment, List<List<Integer>> numbers) {
        final int numberOfCustomized = numbers.size();
        final int availableNumberOfLotteries = LotteryPrice.calculateAvailableLottery(investment);
        final int numberOfRandomized = availableNumberOfLotteries - numberOfCustomized;

        final List<Lottery> customizedLotteries = this.createCustomizedLotteries(numbers);
        final List<Lottery> randomizedLotteries = this.createRandomizedLotteries(numberOfRandomized);

        final List<Lottery> lotteryList = new ArrayList<>();
        lotteryList.addAll(customizedLotteries);
        lotteryList.addAll(randomizedLotteries);

        return Lotteries.from(lotteryList);
    }

    private List<Lottery> createRandomizedLotteries(int numberOfLotteries) {
        return IntStream.range(ZERO, numberOfLotteries)
                .mapToObj(number -> LotteryFactory.create(CreateLotteryRequest.random()))
                .collect(Collectors.toList());
    }

    private List<Lottery> createCustomizedLotteries(List<List<Integer>> listOfNumbers) {
        return listOfNumbers.stream()
                .map(numbers -> LotteryFactory.create(CreateLotteryRequest.custom(numbers)))
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
