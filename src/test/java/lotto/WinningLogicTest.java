package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.Reward.*;
import static lotto.ui.TypeConvert.convertStringToIntegerList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class
WinningLogicTest {
    @DisplayName("당첨번호와 로또번호 `비교`시 총 몇개의 같은 숫자가 일치하는지 알 수있다.")
    @Test
    void checkWinningCountTest() {
        WinningLogic winningLogic = new WinningLogic();
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,3,11,22,33,7";
        String winningNumberWithBonus = "1,2,3,11,22,33,6";
        List<Integer> lottoNumbers = convertStringToIntegerList((lottoNumber));
        List<Integer> winningNumbers = convertStringToIntegerList((winningNumber));
        List<Integer> winningNumbersWithBonus = convertStringToIntegerList((winningNumberWithBonus));

        Lotto lotto = new Lotto(lottoNumbers);

        assertAll(
                () -> assertThat(winningLogic.makeMatchCounts(lotto.getLottoNumbers(), winningNumbers))
                        .isEqualTo(Arrays.asList(3, 0)),
                () -> assertThat(winningLogic.makeMatchCounts(lotto.getLottoNumbers(), winningNumbersWithBonus))
                        .isEqualTo(Arrays.asList(3, 1))
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

        TreeMap prizes = winningLogic.makePrizes(rewards);

        assertAll(
                () -> assertThat(prizes.get(5000)).isEqualTo(2),
                () -> assertThat(prizes.get(50000)).isEqualTo(1),
                () -> assertThat(prizes.get(1500000)).isEqualTo(1),
                () -> assertThat(prizes.get(30000000)).isEqualTo(0)
        );
    }
}
