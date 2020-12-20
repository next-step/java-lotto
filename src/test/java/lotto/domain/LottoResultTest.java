package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;
    @BeforeEach
    void setup(){
        LottoBucket lottoBucket = new LottoBucket();
        lottoResult = new LottoResult(lottoBucket);
    }

    @Test
    void checkWinningNumbers () {
        String lastWinningNumbers = "1,2,3,4,5,6";

        LottoBucket lottoBucket = new LottoBucket();
        Lotto lotto = new Lotto().selectedNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoBucket.addLotto( lotto);

        lottoResult = new LottoResult(lottoBucket);
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers);
        long l = winningLottos.amountOfWinning();
        assertThat(l).isEqualTo(WinningLottoType.MATCH_SIX.getWinnerMoney());
    }

    @Test
    void resultWinningLottoTypeWhenlessThanThree() {
        WinningLottoType winningLottoType = lottoResult.resultWinningLottoType(2);
        assertThat(winningLottoType).isEqualTo(WinningLottoType.MATCH_ZERO);
    }

    @Test
    void resultWinningLottoTypeWhenThree() {
        WinningLottoType winningLottoType = lottoResult.resultWinningLottoType(3);
        assertThat(winningLottoType).isEqualTo(WinningLottoType.MATCH_THREE);
    }
}