package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "4000:4"}, delimiter= ':')
    void 로또를_산다(int price, int count) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(price);
        assertEquals(lottoGame.countLotto(), count);
    }

    @ParameterizedTest
    @ValueSource(ints = {200, 1300, 1001})
    void 금액이부족하면_로또가_사지지_않는다(int price) {
        LottoGame lottoGame = new LottoGame();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoGame.buyLotto(price));
    }

    @Test
    void 당첨번호를_받을_수_있다() {
        LottoGame lottoGame = new LottoGame();
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        lottoGame.registerWinningLotto(winningNumbers);
        assertEquals(lottoGame.winningLotto(), new Lotto(winningNumbers));
    }


}
