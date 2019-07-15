package lottogame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;
    private WinningLottoNumber winningLottoNumber;
    private LottoGame lottoGame;
    private List<LottoNumber> lottoManual;
    private LottoNumber dummy;
    private int price = 3000;

    @BeforeEach
    void setup() {
        winningLottoNumber = new WinningLottoNumber("1, 2, 3, 4, 5, 6", 7);
        lottoManual = new ArrayList<>();
        lottoResult = new LottoResult();
    }

    @Test
    void fistWinner_당첨확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.findWinnerData()).isEqualTo(LottoRankData.FIRST_WINNER);
    }

    @Test
    void secondWinner_당첨확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.findWinnerData()).isEqualTo(LottoRankData.SECOND_WINNER);
    }

    @Test
    void bonusSecondWinner_당첨확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.findWinnerData()).isEqualTo(LottoRankData.BONUS_SECOND_WINNER);
    }

    @Test
    void thirdWinner_당첨확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.findWinnerData()).isEqualTo(LottoRankData.THIRD_WINNER);
    }

    @Test
    void forthWinner_당첨확인() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 10, 8, 9));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.findWinnerData()).isEqualTo(LottoRankData.FORTH_WINNER);
    }

    @Test
    void 당첨수익률_계산() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9));
        lottoManual.add(dummy);

        int lottoPrice = 1000;
        lottoGame = new LottoGame(lottoPrice, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);

        DecimalFormat form = new DecimalFormat("#.##");
        System.out.println(lottoResult.getWinningRevenue().getRevenue());

        assertThat(form.format(lottoResult.getWinningRevenue().getRevenue())).isEqualTo(form.format(new BigDecimal(LottoRankData.THIRD_WINNER.getPrize() / lottoPrice)));
    }
}