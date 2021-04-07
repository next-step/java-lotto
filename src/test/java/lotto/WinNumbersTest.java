package lotto;

import lotto.domain.HitCount;
import lotto.domain.Numbers;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinNumbersTest {
    @DisplayName("로또번호와 당첨번호를 비교하여 당첨갯수를 반환한다.")
    @Test
    public void hitCount() {
        WinNumbers winNumbers = new WinNumbers(Arrays.asList(1, 2, 3, 11, 12, 13), 14);
        Numbers lottoNumbers = new Numbers(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertThat(winNumbers.hitNumberCount(lottoNumbers)).isEqualTo(new HitCount(3));
    }

    @DisplayName("로또번호와 당첨번호, 보너스번호를 비교하여 당첨갯수 및 보너스 당첨여부를 반환한다.")
    @Test
    public void hitCount_보너스() {
        WinNumbers winNumbers = new WinNumbers(Arrays.asList(1, 8, 19, 21, 20, 43), 45);
        Numbers lottoNumbers = new Numbers(Arrays.asList(1, 8, 19, 21, 20, 45));

        assertThat(winNumbers.hitNumberCount(lottoNumbers)).isEqualTo(new HitCount(5, true));
    }

    @DisplayName("당첨번호에 문자를 입력시 예외를 반환한다.")
    @Test
    public void invalid_문자() {
        assertThatThrownBy(() -> {
            new WinNumbers(new String[]{"1", "8", "19", "21", "20", "aa"}, 45);
        }).isInstanceOf(NumberFormatException.class);
    }
}
