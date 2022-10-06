package lotto.domain.entity;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.vo.LottoNumber;

class LottoTicketTest {
    @Test
    @DisplayName("같은 로또 숫자이더라도 다른 티켓이다")
    void createWithSameNumbers() {
        List<LottoNumber> lottoNumbers = createLottoNumberList(1, 2, 3, 4, 5, 6);

        assertThat(new LottoTicket(lottoNumbers)).isNotEqualTo(new LottoTicket(lottoNumbers));
    }

    private List<LottoNumber> createLottoNumberList(int... numbers) {
        return Arrays.stream(numbers)
            .mapToObj(LottoNumber::new)
            .collect(toList());
    }
}
