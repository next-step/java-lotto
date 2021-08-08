package lotto.domain;

import lotto.exception.InvalidManualLottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTests {
    @DisplayName("구입 금액을 넣었을때 올바른 개수가 return 되는 지 test")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "14500,14", "100000,100"})
    void getPurchaseCountTest(int purchaseAmount, int expected) {
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        assertThat(lottoMachine.getPurchaseLottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 기계에서 로또 티켓들을 잘 생성되는지 테스트")
    @Test
    void generateLottoNumbersTest() {
        LottoMachine lottoMachine = new LottoMachine(14000);

        LottoTicket lottoTicket = lottoMachine.generateLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoTicket).isEqualTo(lottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 기계에 넣은 금액 보다 수동 로또 구매 갯수가 많을 경우 Exception 테스트")
    @Test
    void manualLottoCountExceptionTest() {
        LottoMachine lottoMachine = new LottoMachine(14000);

        assertThatExceptionOfType(InvalidManualLottoCountException.class)
                .isThrownBy(() -> {
                    lottoMachine.validManualCount(15);
                }).withMessageMatching("수동 로또 구입 금액이 총 금액보다 많습니다.");

    }
}
