package lotto.domain;

import static lotto.domain.LottoNumber.generateNumbers;
import static lotto.domain.Rank.calculateLottoRankBywinCountAndMatchBonus;

public class WinLotto {

    private static final String LOTTO_BONUS_DUPLICATE_ERROR_MESSAGE = "로또의 번호와 보너스 번호는 중복될 수 없다.";

    private final Lotto lotto;

    private final LottoNumber bonus;

    public WinLotto(Lotto lotto, LottoNumber bonus) {
        checkDuplicateLottoAndBonus(lotto, bonus);

        this.lotto = lotto;
        this.bonus = bonus;
    }

    private static void checkDuplicateLottoAndBonus(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(LOTTO_BONUS_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static WinLotto of(String numbers, int bonus) {
        return new WinLotto(new Lotto(numbers), new LottoNumber(bonus));
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoNumber bonus() {
        return bonus;
    }

    public Rank calculateRank(Lotto lotto) {
        int winCount = lotto.calculateWinCount(this.lotto);
        boolean isBonus = lotto.contains(bonus);
        return calculateLottoRankBywinCountAndMatchBonus(winCount, isBonus);
    }

}
