package lotto.model.lotto;


import lotto.model.Hit;
import lotto.model.LottoPrice;
import lotto.strategy.DrawingStrategy;

import java.util.Map;

public class WinningLotto extends Lotto {
    private final static String CONTAIN_BONUS_ERROR_MESSAGE = "당첨 번호에는 보너스 볼 번호가 들어갈 수 없습니다.";
    private LottoNumber bonus;

    public WinningLotto(LottoNumber bonus, DrawingStrategy drawingStrategy) {
        super(drawingStrategy);

        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(CONTAIN_BONUS_ERROR_MESSAGE);
        }

        this.bonus = bonus;
    }

    public Map<Hit, Integer> matches(Lottoes lottoes) {
        return lottoes.matches(this, bonus);
    }

    public double earningRate(Lottoes lottoes, LottoPrice lottoPrice) {
        return lottoes.earningRate(this, bonus, lottoPrice);
    }

}

