package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;

import java.util.Map;

public class LottoWinner extends Lotto {

    private final LottoNumber bonusNumber;
    private static final int BONUS_NUMBER_COUNT = 5;
    private final int SECOND = 2;
    private final int THIRD = 3;
    private static final Map<Integer, Integer> rankMap = Map.of(
            0, 8,
            1, 7,
            2, 6,
            3, 5,
            4, 4,
            6, 1
    );
    private static final String LOTTOWINNER_BONUSNUMBER_EXCEPTION = "보너스 번호는 다른 번호와 겹칠 수 없습니다.";

    public LottoWinner(final LottoNumberSet lottoNumberSet, final LottoNumber bonusNumber) {
        super(lottoNumberSet);
        if (lottoNumberSet.contain(bonusNumber)) {
            throw new IllegalArgumentException(LOTTOWINNER_BONUSNUMBER_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int rank(final Lotto lotto) {
        int count = this.lottoNumbers.match(lotto.lottoNumbers);
        if (count == BONUS_NUMBER_COUNT) {
            return matchBonusNumber(count, lotto.lottoNumbers.contain(bonusNumber));
        }
        return rankMap.get(count);
    }

    private int matchBonusNumber(final int count, final boolean containBonusNumber) {
        if (isSecond(count, containBonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    private static boolean isSecond(int count, boolean containBonusNumber) {
        return count == BONUS_NUMBER_COUNT && containBonusNumber;
    }
}
