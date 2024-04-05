package lottogame.domain;

import java.util.List;

public class LottoGame {
    private static final Money price = Money.from(1_000);

    public ReturnOfRate calculateReturnOfRate(WinningLottos winnerLotto, LottosBundle lottosBundle) {
        return lottosBundle.calculateReturnOfRate(winnerLotto, price);
    }

    public List<Rank> checkRanks(WinningLottos winnerLotto, LottosBundle lottosBundle) {
        return lottosBundle.checkRanks(winnerLotto);
    }

    public LottosBundle createLottosBundle(Number count) {
        return LottoFactory.createLottosBundle(count);
    }

    public LottosBundle createLottosBundle(List<Numbers> numbers) {
        return LottoFactory.createLottosBundle(numbers);
    }

    public Number calculateCountOfLottos(Money amount) {
        return LottoFactory.calculateCountOfLottos(amount, price);
    }

    public WinningLottos createWinningLotto(Numbers numbers, Number bonusNumber) {
        return LottoFactory.createWinningLotto(numbers, bonusNumber.intValue());
    }
}
