package lotto.auto;

import lotto.LottoNumber;
import lotto.LottoWinningStrategy;
import lotto.RANK;
import lotto.SelectedLottoes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class AutoWinningLottoesTest {

    @Test
    @DisplayName("당첨 결과")
    void test1() {
        // given
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(1);
        LottoNumber number3 = new LottoNumber(1);
        LottoWinningStrategy autoWinningLottoes = new AutoWinningLottoes(List.of(number1, number2, number3));
        // when
        Optional<RANK> rank = autoWinningLottoes.calculateWinningResult(new SelectedLottoes(List.of(number1, number2, number3)));
        // then
        assertThat(rank).isPresent().get().isEqualTo(RANK.THREE);
    }
}