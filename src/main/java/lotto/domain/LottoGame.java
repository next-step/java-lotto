package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int BEGIN_INDEX = 0;
    private static final String SEPARATOR = ", ";
    private static final int INIT_COUNT = 1;

    public static long reward(int matchCount) {
        return RewardType.of(matchCount).reward();
    }

    public static long lottoCount(long price) {
        return price / LOTTO_PRICE;
    }

    public static List<Lotto> generateLottos(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public static Lotto winningLotto(String input) {
        String[] split = input.split(SEPARATOR);
        Set<LottoNumber> numbers = new HashSet<>();

        for (int i = BEGIN_INDEX; i < split.length; i++) {
            numbers.add(new LottoNumber(Integer.parseInt(split[i])));
        }
        return new Lotto(numbers);
    }

    public static LottoNumber bonusLottoNumber(int bonusLottoNumber) {
        return new LottoNumber(bonusLottoNumber);
    }

    public static LottoRewards reward(List<Lotto> lottos, WinningLotto winningLotto) {
        LottoRewards lottoRewards = new LottoRewards();

        for (Lotto lotto : lottos) {
            increaseLottoRewardCount(lottoRewards, lotto, winningLotto);
        }

        return lottoRewards;
    }

    private static void increaseLottoRewardCount(LottoRewards lottoRewards, Lotto lotto, WinningLotto winningLotto) {
        if (lotto.isNotWinningMatchCountWith(winningLotto.numbers())) {
            return;
        }

        int matchCount = lotto.matchCount(winningLotto.numbers());
        RewardType rewardType = RewardType.of(matchCount);

        if (rewardType == RewardType.FIVE && lotto.isMatchWith(winningLotto.bonusNumber())) {
            rewardType = RewardType.FIVE_AND_BONUS;
        }

        if (lottoRewards.isNotContainRewardType(rewardType)) {
            lottoRewards.add(new LottoReward(rewardType, INIT_COUNT));
            return;
        }
        lottoRewards.increaseCountOf(rewardType);
    }

    public static double totalProfitRate(LottoRewards lottoRewards, long purchasePrice) {
        return (double) lottoRewards.totalProfit() / purchasePrice;
    }
}
