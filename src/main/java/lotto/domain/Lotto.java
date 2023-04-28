package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;
    private static final int BEGIN_INDEX = 0;
    private static final String SEPARATOR = ", ";
    private static final int BEGIN_MATCH_COUNT = 1;
    private static final int INIT_COUNT = 1;

    public static long reward(int matchCount) {
        return RewardType.of(matchCount).reward();
    }

    public static long lottoCount(long price) {
        return price / LOTTO_PRICE;
    }

    public static Set<LottoNumbers> generateAllLottoNumbers(long lottoCount) {
        Set<LottoNumbers> lottoNumbersSet = new HashSet<>();
        for (int i = BEGIN_INDEX; i < lottoCount; i++) {
            lottoNumbersSet.add(new LottoNumbers());
        }
        return lottoNumbersSet;
    }

    public static LottoNumbers winningLottoNumbers(String input) {
        String[] split = input.split(SEPARATOR);
        Set<LottoNumber> numbers = new HashSet<>();

        for (int i = BEGIN_INDEX; i < split.length; i++) {
            numbers.add(new LottoNumber(Integer.parseInt(split[i])));
        }
        return new LottoNumbers(numbers);
    }

    public static double totalProfitRate(Set<LottoNumbers> lottoNumbersSet, LottoNumbers winningLottoNumbers) {
        long purchasePrice = lottoNumbersSet.size() * LOTTO_PRICE;
        long totalReward = 0l;

        for (LottoNumbers lottoNumbers : lottoNumbersSet) {
            if (lottoNumbers.isNotWinningMatchCountWith(winningLottoNumbers)) {
                continue;
            }

            totalReward += RewardType.of(lottoNumbers.matchCount(winningLottoNumbers)).reward();
        }
        return totalReward / (double) purchasePrice;
    }

    public static LottoRewards reward(Set<LottoNumbers> lottoNumbersSet, LottoNumbers winningLottoNumbers) {
        LottoRewards lottoRewards = new LottoRewards();

        for (LottoNumbers lottoNumbers : lottoNumbersSet) {
            if (lottoNumbers.isNotWinningMatchCountWith(winningLottoNumbers)) {
                continue;
            }

            int matchCount = lottoNumbers.matchCount(winningLottoNumbers);
            RewardType rewardType = RewardType.of(matchCount);

            if (lottoRewards.isNotContainRewardType(rewardType)) {
                lottoRewards.add(new LottoReward(rewardType, INIT_COUNT));
                continue;
            }
            lottoRewards.increaseCountOf(rewardType);
        }

        return lottoRewards;
    }
}
