package lottogame.domain.lotto;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("같은 로또 숫자이더라도 다른 티켓이다")
    void createWithSameNumbers() {
        LottoNumbers lottoNumbers = createLottoNumberList(1, 2, 3, 4, 5, 6);

        assertThat(new LottoTicket(lottoNumbers)).isNotEqualTo(new LottoTicket(lottoNumbers));
    }

    private LottoNumbers createLottoNumberList(int... numbers) {
        return new LottoNumbers(Arrays.stream(numbers)
            .mapToObj(LottoNumber::new)
            .collect(toList()));
    }
}
