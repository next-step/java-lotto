package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;
    private BonusNumber bonusNumber;
    @BeforeEach
    void setup(){
        LottoBucket lottoBucket = new LottoBucket();
        bonusNumber = new BonusNumber();
        lottoResult = new LottoResult(lottoBucket);
    }

    @Test
    void checkWinningNumbers () {
        String lastWinningNumbers = "1,2,3,4,5,6";
        String inputBonusNumber = "8";
        LottoBucket lottoBucket = new LottoBucket();
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto().selectedNumber(lottoNumberSet);
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
        Set<LottoNumber> lottoNumberSet = generateCustomNumber(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto lotto = new Lotto().selectedNumber(lottoNumberSet);
        lottoBucket.addLotto( lotto);

        BonusNumber bonusNumber = new BonusNumber(lastWinningNumbers, inputBonusNumber);
        lottoResult = new LottoResult(lottoBucket);
        WinningLottos winningLottos = lottoResult.checkWinningNumbers(lastWinningNumbers,bonusNumber);
        BigDecimal winningMoney = winningLottos.amountOfWinning();
        long winnerMoney = WinningLottoType.MATCH_FIVE_BONUS.getWinnerMoney();
        assertThat(winningMoney).isEqualTo( new BigDecimal(winnerMoney));
    }

    private Set<LottoNumber> generateCustomNumber(List<Integer> customLottoNumbers) {
        Set<LottoNumber> lottoNumberSet = customLottoNumbers.stream()
                .map(LottoNumber::new).collect(Collectors.toSet());
        return lottoNumberSet;
    }

}