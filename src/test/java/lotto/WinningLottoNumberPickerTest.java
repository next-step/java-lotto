package lotto;


import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningLottoNumberPickerTest {

    private static final String TEST_NUMBER = "2,4,6,8,10,12";
    private static final int BONUS_NUMBER = 1;

    WinningNumbers winningNumbers;
    List<Integer> lottoNumber;

    @BeforeEach
    void settingWinningNumber() {
        winningNumbers = new WinningNumbers(TEST_NUMBER, BONUS_NUMBER);
        lottoNumber = Arrays.stream(TEST_NUMBER.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Test
    void 당첨번호_몇개인지_체크() {
        assertThat(winningNumbers.checkOverlapNumber(lottoNumber))
                .isEqualTo(6);
    }

    @Test
    void 보너스번호가_없는지_체크() {
        assertThat(winningNumbers.checkBonusNumber(lottoNumber))
                .isFalse();
    }

    @Test
    void 보너스번호가_있는지_체크() {
        lottoNumber.add(0, 1);
        assertThat(winningNumbers.checkBonusNumber(lottoNumber))
                .isTrue();
    }

}
