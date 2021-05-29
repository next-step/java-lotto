package step5.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.utils.StringUtils;
import static org.assertj.core.api.Assertions.assertThat;

class lottoTest {
    @DisplayName("로또 자동 생성 후 생성된 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void createAutoLotto(int price, int expected) {
        Lotto lotto = new Lotto(price, 0);
        lotto.addAutoLottoTicket();
        assertThat(lotto.getLottoTickets().size()).isEqualTo(expected);
    }

    @DisplayName("로또 수동 생성 후 생성된 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void createManualLotto(int price, int manualCount) {
        Lotto lotto = new Lotto(price, manualCount);
        for (int i = 0; i < manualCount; i++) {
            lotto.addManualLottoTicket(StringUtils.processStringNumbers("1,2,3,4,5,6"));
        }
        assertThat(lotto.getLottoTickets().size()).isEqualTo(manualCount);
    }

    @DisplayName("로또 자동/수동 생성 후 생성된 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:3", "7000:2"}, delimiter = ':')
    void createAutoAndManualLotto(int price, int manualCount) {
        //given
        Lotto lotto = new Lotto(price, manualCount);

        //when
        for (int i = 0; i < manualCount; i++) {
            lotto.addManualLottoTicket(StringUtils.processStringNumbers("1,2,3,4,5,6"));
        }
        lotto.addAutoLottoTicket();
        int totalLottoCount = lotto.getLottoCount().autoLottoCount() + lotto.getLottoCount().manualLottoCount();

        //then
        assertThat(lotto.getLottoTickets().size()).isEqualTo(totalLottoCount);
    }
}