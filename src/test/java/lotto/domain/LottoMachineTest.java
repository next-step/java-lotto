package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoMachineTest {

    @Test
    @DisplayName("구입한 금액 확인 가능")
    void buyLottoPrice() {
        LottoMachine lottoMachine = new LottoMachine(10000);

        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(lottoTickets).hasSize(10);
    }

    @Test
    @DisplayName("구입한 갯수를 알 수 있다.")
    void lottoCount() {
        LottoMachine lottoMachine = new LottoMachine(10000);

        assertThat(lottoMachine.lottoTotalCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 구입 금액 정합성 체크")
    void validLottoPrice() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(500);
                }).withMessageContaining("구매 금액 에러");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    // when
                    LottoMachine lottoMachine = new LottoMachine(1500);
                }).withMessageContaining("구매 금액 에러");
    }

    @Test
    @DisplayName("로또 당첨번호를 저장 할 수 있다.")
    void saveWinningLottoNumber() {
        LottoMachine lottoMachine = new LottoMachine(1000);

        int testBounsNumber = 7;
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(new LottoTicket("1,2,3,4,5,6"), testBounsNumber);

        lottoMachine.initLottoStatistic(winningLottoTicket);

        WinningLottoTicket actualWinnerNumber = lottoMachine.getWinningLottoNumber();

        assertThat(actualWinnerNumber.getWinningLottoNumbers())
                .hasSize(6)
                .contains(LottoNumber.getLottoNumber(1)
                        , LottoNumber.getLottoNumber(2)
                        , LottoNumber.getLottoNumber(3)
                        , LottoNumber.getLottoNumber(4)
                        , LottoNumber.getLottoNumber(5)
                        , LottoNumber.getLottoNumber(6)
                );

        assertThat(actualWinnerNumber.getBounsNumber()).isEqualTo(LottoNumber.getLottoNumber(7));
    }

    @DisplayName("수동 로또 정합성 체크")
    @Test
    void vaildManualPurchaseLotto() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {

                    List<String> lottos = List.of("1,2,3,4,5,6", "4,5,6,7,8,9");

                    LottoMachine lottoMachine = new LottoMachine(5000, lottos, 3);

                }).withMessageContaining("수동 로또 갯수 에러");
    }

    @DisplayName("수동로또 구매 테스트")
    @Test
    void manualPurchaseLottos() {

        List<String> lottos = List.of("1,2,3,4,5,6", "4,5,6,7,8,9");

        LottoMachine lottoMachine = new LottoMachine(5000, lottos, 2);

        int manualPurchaseLottsCount = lottoMachine.getManualPurchaseCount();
        List<LottoTicket> lottoTickets = lottoMachine.getLottoTickets();

        assertThat(manualPurchaseLottsCount).isEqualTo(2);
        assertThat(lottoTickets).hasSize(5);

    }
}
