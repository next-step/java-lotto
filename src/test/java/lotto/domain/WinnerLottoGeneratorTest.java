package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerLottoGeneratorTest {

    @Test
    @DisplayName("당첨로또를 생성한다.")
    void create_winner_lotto() {
        // given
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinnerLottoGenerator winnerLottoGenerator = new WinnerLottoGenerator();

        // when
        WinnerLotto result = winnerLottoGenerator.createWinnerLotto(lottoNumbers, bonusNumber);

        // then
        assertThat(result).isEqualTo(new WinnerLotto(LottoNumber.valueOf(7), 1, 2, 3, 4, 5, 6));
    }
}