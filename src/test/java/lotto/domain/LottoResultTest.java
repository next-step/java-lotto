package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
        String inputBonusNumber = "8";
        LottoBucket lottoBucket = new LottoBucket();
        Lotto lotto = new Lotto().selectedNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoBucket.addLotto( lotto);
        BonusNumber bonusNumber = new BonusNumber(lastWinningNumbers, inputBonusNumber);

        lottoResult = new LottoResult(lottoBucket);
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers, bonusNumber);
        BigDecimal winningMoney = winningLottos.amountOfWinning();
        long winnerMoney = WinningLottoType.MATCH_SIX.getWinnerMoney();
        assertThat(winningMoney).isEqualTo(new BigDecimal(winnerMoney));
    }
    @Test
    void checkWinningBonusNumber() {
        String lastWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "8";
        LottoBucket lottoBucket = new LottoBucket();
        Lotto lotto = new Lotto().selectedNumber(Arrays.asList(1, 2, 3, 4, 5, 8));
        lottoBucket.addLotto( lotto);

        BonusNumber bonusNumber = new BonusNumber(lastWinningNumbers, inputBonusNumber);
        lottoResult = new LottoResult(lottoBucket);
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers,bonusNumber);
        BigDecimal winningMoney = winningLottos.amountOfWinning();
        long winnerMoney = WinningLottoType.MATCH_FIVE_BONUS.getWinnerMoney();
        assertThat(winningMoney).isEqualTo( new BigDecimal(winnerMoney));
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