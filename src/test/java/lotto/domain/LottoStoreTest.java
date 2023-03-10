package lotto.domain;

import lotto.ui.LottoRequest;
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
        store = new LottoStore();
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14:auto", "5300:5:auto"}, delimiter = ':')
    void 로또개수를_구한다(int price, int lottoNumber, String type) {
        // given
        LottoRequest request = new LottoRequest(price, type);

        // when
        LottoTickets tickets = store.buyLotto(request);

        // then
        assertThat(tickets.size()).isEqualTo(lottoNumber);
    }

    @Test
    void 구매금액이_부족하면_예외가_발생한다() {

        // given
        int price = 900;
        String type = "auto";
        LottoRequest request = new LottoRequest(price, type);

        // sad case
        assertThatThrownBy(() -> store.buyLotto(request))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
