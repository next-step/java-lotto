package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

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

    @DisplayName("로또 추첨 중복 테스트")
    @Test
    public void test() {

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);

        LottoNumber lottoNumber = new LottoNumber(6);
        assertThatThrownBy(
                () -> {
                    LottoBundle lottoBundle = new LottoBundle(10);
                    lottoBundle.draw(lottoNumbers, lottoNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
