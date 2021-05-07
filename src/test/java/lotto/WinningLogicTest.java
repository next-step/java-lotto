package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.Reward.*;
import static lotto.ui.TypeConvert.convertStringListToIntegerList;
import static lotto.ui.TypeConvert.convertStringToStringList;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningLogicTest {
    @DisplayName("당첨번호와 로또번호 `비교`시 총 몇개의 같은 숫자가 일치하는지 알 수있다.")
    @Test
    void checkWinningCountTest() {
        WinningLogic winningLogic = new WinningLogic();
        String lottoNumber = "1,2,3,4,5,6";
        String winningNumber = "1,2,3,11,22,33,7";
        List<Integer> lottoNumbers = convertStringListToIntegerList(convertStringToStringList(lottoNumber));
        List<Integer> winningNumbers = convertStringListToIntegerList(convertStringToStringList(winningNumber));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(winningLogic.makeMatchCounts(lotto.getLottoNumbers(),winningNumbers))
                .isEqualTo(Arrays.asList(3,0));
    }

    @Test
    @DisplayName("상품 당첨 해쉬맵 테스트")
    void makePrizesTest() {
        WinningLogic winningLogic = new WinningLogic();
        List<Reward> rewards = new ArrayList<>();

        rewards.add(MATCH_3);
        rewards.add(MATCH_4);
        rewards.add(MATCH_5);
        rewards.add(MATCH_3);

        TreeMap prizes =  winningLogic.makePrizes(rewards);

        assertAll(
                ()-> assertThat(prizes.get(5000)).isEqualTo(2),
                ()-> assertThat(prizes.get(50000)).isEqualTo(1),
                ()-> assertThat(prizes.get(1500000)).isEqualTo(1),
                ()-> assertThat(prizes.get(30000000)).isEqualTo(0)
        );
    }
}
