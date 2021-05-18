package lotto;

import lotto.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.model.Reward.*;
import static lotto.util.TypeConvert.convertStringToLottoNumberSet;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class
WinningLogicTest {
    @DisplayName("당첨번호와 로또번호 `비교`시 총 몇개의 같은 숫자가 일치하는지 알 수있다.")
    @Test
    void makeWinningStateTest() {
        WinningLogic winningLogic = new WinningLogic();
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,11,22,33,3";
        LottoNumber incorrectBonusBall = new LottoNumber(7);
        LottoNumber correctBonusBall = new LottoNumber(6);
        Set<LottoNumber> lottoNumbers = convertStringToLottoNumberSet((lottoNumber));
        Set<LottoNumber> winningLottoNumbers = convertStringToLottoNumberSet((winningNumber));

        Lotto lotto = new Lotto(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers,incorrectBonusBall);
        WinningLotto winningLottoWithBonus = new WinningLotto(winningLottoNumbers,correctBonusBall);
        WinningState threeMatchedWinningLotto = winningLogic.makeWinningState(lotto, winningLotto);
        WinningState threeMatchedWinningLottoWithBonus = winningLogic.makeWinningState(lotto, winningLottoWithBonus);

        assertAll(
                () -> assertThat(threeMatchedWinningLotto.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLotto.getBonusBallState()).isFalse(),
                () -> assertThat(threeMatchedWinningLottoWithBonus.getMatchedCount()).isEqualTo(3),
                () -> assertThat(threeMatchedWinningLottoWithBonus.getBonusBallState()).isTrue()
        );
    }

    @Test
    @DisplayName("상품 당첨 해쉬맵 테스트")
    void makePrizesTest() {
        WinningLogic winningLogic = new WinningLogic();
        List<Reward> rewards = new ArrayList<>();

        rewards.add(FIFTH_PRIZE);
        rewards.add(FOURTH_PRIZE);
        rewards.add(THIRD_PRIZE);
        rewards.add(FIFTH_PRIZE);

        Map prizes = winningLogic.makePrizes(rewards);

        assertAll(
                () -> assertThat(prizes.get(5000)).isEqualTo(2),
                () -> assertThat(prizes.get(50000)).isEqualTo(1),
                () -> assertThat(prizes.get(1500000)).isEqualTo(1),
                () -> assertThat(prizes.get(30000000)).isEqualTo(0)
        );
    }
}
