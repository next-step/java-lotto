package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectedLottoNumbersTest {

    @Test
    @DisplayName("당첨 로또 존재 확인")
    void test() {
        // given
        SelectedLottoNumbers selectedLottoNumbers = new SelectedLottoNumbers(List.of(new LottoNumber(1)));
        // when
        boolean isWinning1 = selectedLottoNumbers.isWinning(new LottoNumber(1));
        boolean isWinning2 = selectedLottoNumbers.isWinning(new LottoNumber(2));
        // then
        assertThat(isWinning1).isTrue();
        assertThat(isWinning2).isFalse();
    }
}
