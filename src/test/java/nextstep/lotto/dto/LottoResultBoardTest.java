package nextstep.lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoResultBoardTest {

    @Test
    void lottoBoard() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(6));
        resultBoard.addLottoResult(LottoRank.of(6));
        resultBoard.addLottoResult(LottoRank.of(6));
        Map<LottoRank, Integer> lottoResult = resultBoard.getLottoResult();

        assertThat(lottoResult.get(LottoRank.SIX)).isEqualTo(3);
    }

    @Test
    @DisplayName("5천원구입으로 5등수익률")
    void lottoBenefit_5등_Test() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        assertThat(resultBoard.getBenefitRate()).isEqualTo(0);
    }

    @Test
    @DisplayName("5천원구입으로 4등수익률")
    void lottoBenefit_4등_Test() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(3));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        assertThat(resultBoard.getBenefitRate()).isEqualTo(1);
    }

    @Test
    @DisplayName("5천원구입으로 3등수익률")
    void lottoBenefit_3등_Test() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(4));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        assertThat(resultBoard.getBenefitRate()).isEqualTo(10);
    }

    @Test
    @DisplayName("5천원구입으로 2등수익률")
    void lottoBenefit_2등_Test() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(5));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        assertThat(resultBoard.getBenefitRate()).isEqualTo(300);
    }

    @Test
    @DisplayName("5천원구입으로 1등수익률")
    void lottoBenefit_1등_Test() {
        LottoResultBoard resultBoard = new LottoResultBoard();
        resultBoard.addLottoResult(LottoRank.of(6));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        resultBoard.addLottoResult(LottoRank.of(0));
        assertThat(resultBoard.getBenefitRate()).isEqualTo(400000);
    }

}
