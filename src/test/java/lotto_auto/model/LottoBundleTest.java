package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBundleTest {

    @DisplayName("로또 티켓 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            10,
            40,
            20
    })
    public void createLottoTest(int ticketCount) {
        LottoBundle lottoBundle = new LottoBundle(ticketCount);
        assertThat(lottoBundle.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("로또 ticket count 와 export 한 티켓의 수가 동일한지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            10,
            40,
            20
    })
    public void equalTickCountExportCountTest(int ticketCount) {
        LottoBundle lottoBundle = new LottoBundle(ticketCount);
        assertAll(
                () -> assertThat(lottoBundle.getTicketCount()).isEqualTo(ticketCount),
                () -> assertThat(lottoBundle.export().size()).isEqualTo(ticketCount),
                () -> assertThat(lottoBundle.export().size()).isEqualTo(lottoBundle.getTicketCount())
        );
    }

    @DisplayName("로또 티켓수를 음수로 입력 받았을때 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            -200,
            -7
    })
    public void enterNegativeValueExceptionTest(int ticketCount) {
        assertThatThrownBy(
                () -> new LottoBundle(ticketCount)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("export Ticket isNotNull")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            2,
            10,
            40,
            20
    })
    public void exportTicketIsNotNullTest(int ticketCount) {
        LottoBundle lottoBundle = new LottoBundle(ticketCount);
        assertThat(lottoBundle.export()).isNotNull();
    }
}
