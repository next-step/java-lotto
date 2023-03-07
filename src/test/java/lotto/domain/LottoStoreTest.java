package lotto.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "5300:5", "1000:1"}, delimiter = ':')
    void 구매금액만큼_로또개수를_검증한다(int price, int expected) {
        // happy case
        LottoStore store = new LottoStore() {
            @Override
            protected int calLottoTicketCount(int price) {
                return super.calLottoTicketCount(price);
            }
        };

        int actual = store.calLottoTicketCount(price);

        assertThat(actual).isEqualTo(expected);

        // sad case
        assertThatThrownBy(() -> store.calLottoTicketCount(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_티켓을_구매한다() {

        // given
        int price = 14000;
        LottoStore store = new LottoStore();

        // when
        LottoTickets tickets = store.buyLotto(price);

        // then
        assertThat(tickets.size()).isEqualTo(14);
    }
}
