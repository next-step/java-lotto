package step5.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

class lottoTest {
    @DisplayName("구입 금액만큼 로또 티켓이 생성되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void countLottoTickets(int price, int expected) {
        Lotto lotto = new Lotto(price);
        assertThat(lotto.size()).isEqualTo(expected);
    }

    @DisplayName("생성된 로또 테켓들 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void getLottoTickets(int price, int result) {
        Lotto lotto = new Lotto(price);
        assertThat(lotto.getLottoTickets().size()).isEqualTo(result);
    }

    @DisplayName("로또 개수 가져오기")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void getLottoCount(int price, int result) {
        Lotto lotto = new Lotto(price);
        assertThat(lotto.getLottoCount()).isEqualTo(result);
    }

    @DisplayName("로또 개수를 구입금액으로 변환")
    @ParameterizedTest
    @ValueSource(strings = {"14000", "1000", "6000"})
    void getPurchasePrice(int price) {
        Lotto lotto = new Lotto(price);
        assertThat(lotto.getPurchasePrice()).isEqualTo(price);
    }
}