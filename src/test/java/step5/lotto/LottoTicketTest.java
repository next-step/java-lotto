package step5.lotto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step5.utils.StringUtils;
import java.util.Set;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket();
    }

    @DisplayName("lottoTicket 번호 랜덤 출력 확인")
    @RepeatedTest(100)
    void getLottoNumbers() {
        lottoTicket.createAutoLottoNumbers();
        log.println(lottoTicket.getLottoNumberList());
    }

    @DisplayName("lottoTicket 번호 랜덤으로 6자리 생성 확인")
    @RepeatedTest(100)
    void checkDigits() {
        lottoTicket.createAutoLottoNumbers();
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("lottoTicket 번호 수동 생성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,5,7,12,15,30"})
    void createManualLottoTicket(String inputNumbers) {
        Set<Integer> lottoNumbers = StringUtils.processStringNumbers(inputNumbers);
        lottoTicket.createManualLottoNumbers(lottoNumbers);
        assertThat(lottoTicket.getLottoNumberList().toArray()).isEqualTo(lottoNumbers.toArray());
    }

    @DisplayName("로또 티켓 번호에 당첨 번호가 포함되어있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3:1", "1,5,7,12,15,30:22:0"}, delimiter = ':')
    void isContainNumber(String inputLottoNumbers, int winningNumber, int expected) {
        //given
        Set<Integer> lottoTicketSet = StringUtils.processStringNumbers(inputLottoNumbers);
        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.createManualLottoNumbers(lottoTicketSet);

        //when
        int result = lottoTicket.containNumber(new LottoNumber(winningNumber));

        //then
        assertThat(result).isEqualTo(expected);
    }
}