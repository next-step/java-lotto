package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoMachine 클래스 테스트")
class LottoMachineTest {

    @DisplayName("LottoMachine 생성 시 lottoTicket을 발급할 수 있다.")
    @Test
    void createTicket() {
        LottoMachine lottoMachine = new LottoMachine(new Price(1000), Collections.emptyList());
        assertThat(lottoMachine.getLottoTicket().getLottoNumbers()).hasSize(1);
    }

    @DisplayName("LottoTicket과 winningLotto, bonusNumber를 매칭할 수 있다.")
    @Test
    void match() {
        Price price = new Price(1000);
        LottoMachine lottoMachine = new LottoMachine(price, Collections.singletonList("1,2,3,4,5,6"));

        String winningNumberString = "1,2,3,4,5,6";
        int bonusNumber = 7;

        Map<LottoRank, Long> rankMap = lottoMachine.match(winningNumberString, bonusNumber);

        assertThat(rankMap.get(LottoRank.FIRST)).isEqualTo(new Long(price.getLottoCount()));
    }
}
