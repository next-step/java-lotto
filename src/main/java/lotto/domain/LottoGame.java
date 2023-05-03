package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int BEGIN_INDEX = 0;
    private static final String SEPARATOR = ", ";

    public static long reward(int matchCount) {
        return RewardType.of(matchCount).reward();
    }

    public static long lottoCount(long price) {
        return price / LOTTO_PRICE;
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
            lotto.increaseLottoRewardCount(lottoRewards, winningLotto);
        }

        return lottoRewards;
    }

    public static double totalProfitRate(LottoRewards lottoRewards, long purchasePrice) {
        return (double) lottoRewards.totalProfit() / purchasePrice;
    }
}
