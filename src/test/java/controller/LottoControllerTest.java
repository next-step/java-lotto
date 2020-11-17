package controller;

import domain.Lotto;
import domain.LottoInfo;
import domain.LottoNumbers;
import domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        Lottos lottos = controller.initLottos();
        assertThat(lottos.getLottos().size()).isEqualTo(quantity);
    }

    @ParameterizedTest
    @DisplayName("당첨번호와 로또 번호 일치 개수 계산 기능 - 1개부터 5개까지")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:13, 8, 9, 10, 11, 12:0",
            "1, 2, 3, 4, 5, 6:1, 8, 9, 10, 11, 12:1",
            "1, 2, 3, 4, 5, 6:1, 2, 9, 10, 11, 12:2",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 10, 11, 12:3",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 11, 12:4",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 12:5",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:6",
        }, delimiter = ':')
    void matchLottoNumbersDynamic(String winning, String test, int match) {
        LottoNumbers winningNumbers = new LottoNumbers()
                .createWinningNumbers(winning);
        Lotto winningLotto = new Lotto(winningNumbers);

        LottoNumbers testNumbers = new LottoNumbers()
                .createWinningNumbers(test);
        Lotto testLotto = new Lotto(testNumbers);

        controller = new LottoController();

        assertThat(controller.matchLottoNumbers(winningLotto, testLotto))
                .isEqualTo(match);
    }

}