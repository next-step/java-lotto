package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 6})
    void 생성성공(Integer size) {
        assertThat(LottoTickets.from(size).size()).isEqualTo(size);
    }

}
