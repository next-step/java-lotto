package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.ui.TypeConvert.convertStringListToIntegerList;
import static lotto.ui.TypeConvert.convertStringToStringList;

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

        Assertions.assertThat(winningLogic.makeMatchCounts(lotto.getLottoNumbers(),winningNumbers))
                .isEqualTo(Arrays.asList(3,0));
    }
}
