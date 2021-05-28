package step5.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class lottoTest {
    @DisplayName("구입 금액만큼 로또 티켓이 생성되었는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void countLottoTickets(int price, int expected) {
        LottoCount lottoCount = new LottoCount(price);
        Lotto lotto = new Lotto(lottoCount);
        assertThat(lotto.size()).isEqualTo(expected);
    }
}