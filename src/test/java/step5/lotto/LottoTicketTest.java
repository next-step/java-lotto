package step5.lotto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
        log.println(lottoTicket.getLottoNumbers());
    }

    @DisplayName("lottoTicket 번호 랜덤으로 6자리 생성 확인")
    @RepeatedTest(100)
    void checkDigits() {
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("당첨번호 안에 숫자가 포함되어있는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3:1", "1,5,7,12,15,30:22:0"}, delimiter = ':')
    void isContainNumber(String inputLottoNumbers, int number, int expected) {
        Set<Integer> lottoTicketSet = StringUtils.processStringNumbers(inputLottoNumbers);
        LottoTicket lottoTicket = new LottoTicket(lottoTicketSet);
        int result = lottoTicket.containNumber(new LottoNumber(number));
        assertThat(result).isEqualTo(expected);
    }
}