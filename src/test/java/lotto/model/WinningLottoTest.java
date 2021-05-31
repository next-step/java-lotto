package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningLottoTest {
    @DisplayName("로또번호와 당첨번호의 보너스 볼이 일치하지않는경우 서로 일치하는 숫자와 보너스 볼 일치 여부를 알 수있다")
    @Test
    void makeWinningStateWithFalseBonusBallTest() {
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,3,11,22,33";
        LottoNumber incorrectBonusBall = new LottoNumber(7);
        Set<LottoNumber> lottoNumbers = convertStringToLottoNumberSet((lottoNumber));
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);
        WinningState threeMatchedWinningLotto = winningLotto.makeWinningState(lotto);


        assertAll(
                () -> assertThat(threeMatchedWinningLotto.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLotto.isBonusBallMatchSuccess()).isFalse()
        );
    }

    @DisplayName("로또번호와 당첨번호의 보너스 볼이 일치하는경우 서로 일치하는 숫자와 보너스 볼 일치 여부를 알 수있다")
    @Test
    void makeWinningStateWithTrueBonusBallTest() {
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,3,11,22,33";
        LottoNumber correctBonusBall = new LottoNumber(6);
        Set<LottoNumber> lottoNumbers = convertStringToLottoNumberSet((lottoNumber));
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLottoNumbers, correctBonusBall);
        WinningState threeMatchedWinningLottoWithBonus = winningLottoWithBonus.makeWinningState(lotto);

        assertAll(
                () -> assertThat(threeMatchedWinningLottoWithBonus.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLottoWithBonus.isBonusBallMatchSuccess()).isTrue()
        );
    }
}
