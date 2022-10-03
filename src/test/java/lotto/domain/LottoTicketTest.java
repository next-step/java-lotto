package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("같은 로또 숫자이더라도 다른 티켓이다")
    void createWithSameNumbers() {
        List<LottoNumber> lottoNumbers = createLottoNumberList(List.of(1, 2, 3, 4, 5, 6));

        assertThat(new LottoTicket(lottoNumbers)).isNotEqualTo(new LottoTicket(lottoNumbers));
    }

    private List<LottoNumber> createLottoNumberList(List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}
