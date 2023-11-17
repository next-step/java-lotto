package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

    @DisplayName("원하는 개수만큼의 로또 티켓을 만든다.")
    @Test
    void createLottoTicketAsYouWant() {
        LottoFactory lottoFactory = new LottoFactory();
        List<Lotto> lottoList = lottoFactory.from(10);
        assertThat(lottoList.size()).isEqualTo(10);
    }
}
