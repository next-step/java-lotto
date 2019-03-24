package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.RankPrintableFactory.makeRanksForPrint;
import static util.Random.generationRandom;

public class Lotteries {
    private static final int LOTTO_AMOUNT = 1000;
    private static final int MINIMUM_INPUT_AMOUNT = 1;
    private static final int INITIALIZATION_NUMBER = 0;

    private List<Lottery> lotteries;
    private int purchaseQuantity;

    public Lotteries(String purchaseAmount) {
        this.lotteries = new ArrayList<>();
        this.purchaseQuantity = Integer.parseInt(purchaseAmount) / LOTTO_AMOUNT;

        checkPurchaseValidation(purchaseAmount);
        generationAllLotto();
    }

    public Lotteries(int purchaseQuantity) {
        this(String.valueOf(purchaseQuantity));
    }

    public void generationAllLotto() {
        for(int i = 0; i < this.purchaseQuantity; i++) {
            this.lotteries.add(new Lottery(generationRandom()));
        }
    }

    public static void checkPurchaseValidation(String purchaseAmount) {
        if(LOTTO_AMOUNT < MINIMUM_INPUT_AMOUNT) {
            throw  new IllegalArgumentException();
        }

        if(StringUtils.isEmpty(purchaseAmount)) {
            throw new IllegalArgumentException();
        }

        if(Integer.parseInt(purchaseAmount) < LOTTO_AMOUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int lotteriesSize() {
        return this.lotteries.size();
    }

    public int calculateProfit(LotteryMachine lotteryMachine) {
        int totalProfit = INITIALIZATION_NUMBER;

        for (int i = 0; i < lotteriesSize(); i++) {
            totalProfit += lotteryMachine.countProfit(this.lotteries.get(i));
        }

        return totalProfit;
    }

    public StringBuilder toStringAllLotteries() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lottery lottery : this.lotteries) {
            stringBuilder.append(lottery.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }

    public static void initialization(Map<String, Integer> ranks) {
        ranks.put("first", INITIALIZATION_NUMBER);
        ranks.put("second", INITIALIZATION_NUMBER);
        ranks.put("third", INITIALIZATION_NUMBER);
        ranks.put("fourth", INITIALIZATION_NUMBER);
    }

    public Map<String, Integer> makeAllLotteriesRank(LotteryMachine lotteryMachine) {
        int rank;
        Map<String, Integer> ranks = new HashMap<>();
        initialization(ranks);

        for (int i = 0; i < this.lotteries.size(); i++) {
            rank = lotteryMachine.rankLottery(lotteries.get(i));
            makeRanks(rank, ranks);
        }

        return ranks;
    }

    public void makeRanks(int rank, Map<String, Integer> ranks) {
        RankPrintable rankPrintable = makeRanksForPrint(rank);
        rankPrintable.makeRanksForPrint(ranks);
    }
}
