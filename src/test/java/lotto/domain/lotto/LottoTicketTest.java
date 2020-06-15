package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoTicket.create(1)).doesNotThrowAnyException();
        assertThatCode(() -> LottoTicket.create(3, Arrays.asList("1, 2, 3, 4, 5, 6")))
                .doesNotThrowAnyException();
    }

    @Test
    void 구입_장수만큼_로또번호를_생성한다() {
        int quantity = 5;
        LottoTicket lottoTicket = LottoTicket.create(quantity);

        assertThatCode(() -> lottoTicket.tellLottoNumbers(quantity - 1)).doesNotThrowAnyException();
        assertThatThrownBy(() -> lottoTicket.tellLottoNumbers(quantity)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void 자동로또와_수동로또를_생성한다() {
        int quantity = 2;
        String manualNumber = "8, 21, 23, 41, 42, 43";

        LottoTicket lottoTicket = LottoTicket.create(quantity, Arrays.asList(manualNumber));
        assertThat(lottoTicket.getLottoTicket()).size().isEqualTo(quantity);

    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 구입_장수가_0이하인경우(int quantity) {
        assertThatThrownBy(() -> LottoTicket.create(quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
