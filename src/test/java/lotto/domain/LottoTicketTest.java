package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.fixture.LottoTicketFixture.LOTTO_TICKET1;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("당첨번호개수와 일치하는 숫자를 반환한다.")
    @Test
    void contains() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(LOTTO_TICKET1.countMatchWinningNumber(numbers)).isEqualTo(numbers.size());
    }

}
