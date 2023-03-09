package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoStoreTest {

    private LottoStore store;

    @BeforeEach
    public void setUp() {
        store = new LottoStore() {
            @Override
            protected int calculateLottoTicketCount(int price) {
                return super.calculateLottoTicketCount(price);
            }
        };
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "5300:5"}, delimiter = ':')
    void 구매금액만큼_로또개수를_검증한다(int price, int expected) {
        // when
        int actual = store.calculateLottoTicketCount(price);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"900:1"}, delimiter = ':')
    void 구매금액이_부족하면_예외가_발생한다(int price, int expected) {
        // sad case
        assertThatThrownBy(() -> store.calculateLottoTicketCount(900))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_티켓을_구매한다() {
        // given
        int price = 14000;


        // when
        LottoTickets tickets = store.buyLotto(price);

        // then
        assertThat(tickets.size()).isEqualTo(14);
    }
}
