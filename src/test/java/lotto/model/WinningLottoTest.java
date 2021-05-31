package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static lotto.util.TypeConvert.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningLottoTest {
    @DisplayName("당첨번호와 로또번호 `비교`시 총 몇개의 같은 숫자가 일치하는지 알 수있다.")
    @Test
    void makeWinningStateTest() {
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,11,22,33,3";
        LottoNumber incorrectBonusBall = new LottoNumber(7);
        LottoNumber correctBonusBall = new LottoNumber(6);
        Set<LottoNumber> lottoNumbers = convertStringToLottoNumberSet((lottoNumber));
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, incorrectBonusBall);
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLottoNumbers, correctBonusBall);
        WinningState threeMatchedWinningLotto = winningLotto.makeWinningState(lotto);
        WinningState threeMatchedWinningLottoWithBonus = winningLottoWithBonus.makeWinningState(lotto);

        assertAll(
                () -> assertThat(threeMatchedWinningLotto.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLotto.isBonusBallMatchSuccess()).isFalse(),
                () -> assertThat(threeMatchedWinningLottoWithBonus.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLottoWithBonus.isBonusBallMatchSuccess()).isTrue()
        );
    }
}
