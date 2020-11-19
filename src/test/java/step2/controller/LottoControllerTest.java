package step2.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LottoControllerTest {

    @ParameterizedTest
    @DisplayName("입력한 로또 가격 만큼 티켓 생성 갯수 확인")
    @ValueSource(ints = {14})
    public void 입력한_로또_가격_확인(int lottoAmount) {
        LottoController lottoController = LottoController.of(14000);
        assertEquals(lottoAmount, lottoController.lottoPurchaseQty());
    }

    @ParameterizedTest
    @DisplayName("입력한_가격으로_로또_티켓_정상출력_갯수확인")
    @CsvSource(value = {"14000:14", "2000:2"}, delimiter = ':')
    public void 입력한_가격으로_로또_티켓_정상출력_갯수확인(int lottoAmount, int qty) {
        LottoController lottoController = LottoController.of(lottoAmount);
        assertEquals(qty, lottoController.getLottos().size());
    }

    @Test
    @DisplayName("총 수익율 계산 확인")
    public void 수익율_계산_확인() {
        LottoController lottoController = LottoController.of(13000);
        double totalYield = 0.38;
        assertEquals(totalYield, lottoController.getTotalYield(5000));
    }
}
