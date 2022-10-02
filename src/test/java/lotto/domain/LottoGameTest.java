package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void before() {
        lottoGame = new LottoGame(Arrays.asList(
                new Lotto("1,2,3,4,5,6".split(",")),
                new Lotto("1,2,3,4,5,45".split(",")),
                new Lotto("1,2,3,4,44,45".split(",")),
                new Lotto("1,2,3,43,44,45".split(",")),
                new Lotto("1,2,42,43,44,45".split(","))));
    }

    @Test
    @DisplayName("로또 등수별 갯수 구하기")
    void count_group_by_rank() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6".split(","));
        //when
        LottoResult result = lottoGame.getWinningResult(winningNumbers);
        //then
        assertAll(
                () -> assertThat(result.getFirstCount()).isEqualTo(1),
                () -> assertThat(result.getSecondCount()).isEqualTo(1),
                () -> assertThat(result.getThirdCount()).isEqualTo(1),
                () -> assertThat(result.getFourthCount()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("로또 수익률 계산하기")
    void calculate_earning_rate() {
        //given
        LottoResult winningResult = lottoGame.getWinningResult(new WinningNumbers("1,2,3,4,5,6".split(",")));
        //when
        float earningRate = (LottoResult.FIRST_PRIZE
                +LottoResult.SECOND_PRIZE
                +LottoResult.THIRD_PRIZE
                +LottoResult.FOURTH_PRIZE) / (float) (winningResult.getPurchaseCount() * Lotto.PRICE);
        //then
        assertThat(winningResult.getEarningRate()).isEqualTo(earningRate);
    }

}