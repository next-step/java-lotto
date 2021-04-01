package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoListTest {

    @DisplayName("로또 구매 수량 체크")
    @ParameterizedTest
    @ValueSource(ints = {1,2,10})
    void test(int ticketCount){
        LottoList lottos = new LottoList(ticketCount);
        assertThat(lottos.getLottos().size()).isEqualTo(ticketCount);
    }

}
