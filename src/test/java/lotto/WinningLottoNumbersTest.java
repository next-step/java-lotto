package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoNumbersTest {

    @Test
    @DisplayName("당첨번호 와 보너스 번호 중복체크")
    void create() {
        assertThatThrownBy(() -> {
            WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호가 맞는지 체크")
    void match() {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)), 8);
        int match = winningLottoNumbers.match(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(match).isEqualTo(Rank.FIRST.getMatchedCount());
    }
}