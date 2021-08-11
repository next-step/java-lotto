package lotto;


import lotto.model.LottoNumber;
import lotto.model.LottoNumberPicker;
import lotto.model.LottoNumbers;
import lotto.model.WinningNumber;
import lotto.model.WinningNumbers;
import lotto.util.LottoNumberUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class WinningLottoNumberPickerTest {

    private static final String TEST_NUMBER = "2,4,6,8,10,12";
    private static final int BONUS_NUMBER = 1;
    private static final String SPLIT_TOKEN = ",";

    WinningNumbers winningNumbers;
    LottoNumbers lottoNumbers;

    @BeforeEach
    void settingWinningNumber() {
        winningNumbers = new WinningNumbers(TEST_NUMBER, BONUS_NUMBER);
        lottoNumbers = new LottoNumbers(TEST_NUMBER);
    }

    @Test
    void 당첨번호_몇개인지_체크() {
        assertThat(winningNumbers.checkOverlapNumber(lottoNumbers.selectedNumber()))
                .isEqualTo(6);
    }

    @Test
    void 보너스번호가_없는지_체크() {
        assertThat(winningNumbers.checkBonusNumber(lottoNumbers.selectedNumber()))
                .isFalse();
    }

    @Test
    void 보너스번호가_있는지_체크() {
        lottoNumbers.selectedNumber().add(0, LottoNumberPicker.pickNumber(1));
        assertThat(winningNumbers.checkBonusNumber(lottoNumbers.selectedNumber()))
                .isTrue();
    }

}
