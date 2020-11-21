package controller;

import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoControllerTest {

    LottoController controller;

    @Test
    @DisplayName("구입 금액에 따른 로또 구매 개수 계산 기능")
    void calculateLottoQuantity() {
        int price = 14000;
        controller = new LottoController(price);
        assertThat(controller.getLottoQuantity()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 구매 개수대로 로또 자동 생성 기능")
    void makeAutoLottos() {
        int price = 5000;
        int quantity = 5;
        LottoInfo lottoInfo = LottoInfo.of(price, quantity);
        controller = new LottoController(lottoInfo);

        Lottos lottos = controller.initLottos(quantity);
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

//    @Test
//    @DisplayName("수익률 계산 기능")
//    void calculateProfit() {
//        LottoInfo lottoInfo = LottoInfo.of(4000, 4);
//
//        String winning = "1, 2, 3, 4, 5, 6";
//        LottoNumbers winningNumbers = new LottoNumbers()
//                .createWinningNumbers(winning);
//
//        Lottos lottos = initTestLottos();
//        controller = new LottoController();
//        Map<Integer, Integer> lottoStatistics = controller.compileLottoStatistics(winningNumbers, lottos);
//
//        assertThat(controller.calculateProfit(lottoStatistics, lottoInfo.getPrice()))
//                .isEqualTo(
//                        (double) (LottoPrize.valueOf(3)*2
//                                + LottoPrize.valueOf(6))
//                                / (double) lottoInfo.getPrice()
//                );
//    }

}