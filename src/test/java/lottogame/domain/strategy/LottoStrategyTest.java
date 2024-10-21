package lottogame.domain.strategy;

import lottogame.domain.lotto.LottoNumber;
import lottogame.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoStrategyTest {

    private LottoStrategy strategy;

    @DisplayName("자동으로 6자리 로또 번호가 생성된다.")
    @Test
    void lottoAutoStrategyCreate() {
        strategy = new LottoAutoStrategy();
        LottoNumbers numbers = strategy.generateLottoNumbers();

        int actual = numbers.getLottoNumbers().size();

        assertEquals(6, actual);
    }

    @DisplayName("입력값으로 6자리 로또 번호가 생성된다.")
    @Test
    void PredefinedLottoNumberStrategyCreate() {
        strategy = new PredefinedLottoNumberStrategy("1,2,3,4,5,6");
        LottoNumbers numbers = strategy.generateLottoNumbers();

        int actual = numbers.getLottoNumbers().size();
        LottoNumbers expected = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertEquals(6, actual);
        assertEquals(expected, numbers);
    }
}
