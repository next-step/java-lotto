package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketsTest {

    @ParameterizedTest
    @DisplayName("생성성공")
    @ValueSource(ints = {4, 5, 6, 6})
    void createSuccess(Integer size) {
        assertThat(LottoTickets.from(size).size()).isEqualTo(size);
    }

}
