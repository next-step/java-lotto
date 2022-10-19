package lotto.second;

import lotto.LottoNumber;
import lotto.LottoWinningStrategy;
import lotto.RANK;
import lotto.SelectedLottoes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SecondWinningLottoesTest {

    @Test
    @DisplayName("당첨 결과")
    void test1() {
        // given
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(2);
        LottoNumber number3 = new LottoNumber(3);
        LottoNumber number4 = new LottoNumber(4);
        LottoNumber number5 = new LottoNumber(5);
        LottoNumber number6 = new LottoNumber(6);
        LottoWinningStrategy lottoWinningStrategy = new SecondWinningLottoes(List.of(number1, number2, number3, number4, number5), number6);
        // when
        Optional<RANK> rank = lottoWinningStrategy.calculateWinningResult(new SelectedLottoes(List.of(number1, number2, number3, number4, number5, number6)));
        // then
        assertThat(rank).isPresent().get().isEqualTo(RANK.FIVE_BONUS);
    }
}