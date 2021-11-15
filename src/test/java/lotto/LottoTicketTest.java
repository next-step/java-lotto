package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

class LottoTicketTest {

    @DisplayName("구매하려는 줄 수 만큼 발급이 되는지")
    @ParameterizedTest(name = "[{index}] lineCount: {0}")
    @ValueSource(ints = {1, 7})
    void publish(int lineCount) {
        //given
        LottoTicket lottoTicket = LottoTicket.publish(new Dollars(lineCount * 1000), Collections::shuffle);

        //when
        List<LottoNumbers> lottoLines = lottoTicket.getLottoLines();

        //then
        Assertions.assertThat(lottoLines.size()).isEqualTo(lineCount);
    }

}
