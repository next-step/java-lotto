package study.step3.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.LottoTickets;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("로또 발행횟수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,40,100})
    public void publishLottoTicketsTest(int inputCount){
        assertThat(LottoTickets.publish(inputCount).getLottoTickets())
                .hasSize(inputCount);
    }
}
