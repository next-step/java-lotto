package lotto;

import lotto.domain.LottoTicket;
import lotto.factory.LottoFactory;
import lotto.strategy.ManualLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualLottoStrategyTest {
    @Test
    @DisplayName("로또 수동 생성시 입력받은 로또 번호와 동일한 번호로 로또를 생성한다.")
    void manualLottoStrategy(){
        LottoTicket lottoTicket = LottoFactory.createLottoTicket("1,2,3,4,5,6");
        ManualLottoStrategy strategy = new ManualLottoStrategy(LottoFactory.createLottoTicket("1,2,3,4,5,6"));
        assertThat(strategy.generateLottoNumbers()).isEqualTo(lottoTicket.getLottoTicket());
    }

}
