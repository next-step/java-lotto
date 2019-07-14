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
    private final static int EXIST_COUNT = 1;

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
    void fistWinner() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.getWinnerGroup().stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData())
                .isEqualTo(LottoRankData.FIRST_WINNER);
    }

    @Test
    void secondWinner() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 8));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.getWinnerGroup().stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData())
                .isEqualTo(LottoRankData.SECOND_WINNER);
    }

    @Test
    void bonusSecondWinner() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.getWinnerGroup().stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData())
                .isEqualTo(LottoRankData.BONUS_SECOND_WINNER);
    }

    @Test
    void thirdWinner() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 8, 9));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.getWinnerGroup().stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData())
                .isEqualTo(LottoRankData.THIRD_WINNER);
    }

    @Test
    void forthdWinner() {
        dummy = new LottoNumber(Arrays.asList(1, 2, 3, 10, 8, 9));
        lottoManual.add(dummy);

        lottoGame = new LottoGame(price, lottoManual);
        lottoResult.getWinningResult(lottoGame, winningLottoNumber);
        assertThat(lottoResult.getWinnerGroup().stream()
                .filter(winner -> winner.getCount() == EXIST_COUNT)
                .findAny()
                .orElse(null)
                .getRankData())
                .isEqualTo(LottoRankData.FORTH_WINNER);
    }

    @Test
    void winningRevenueForThirdWinner() {
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