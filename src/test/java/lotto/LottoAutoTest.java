package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoAutoTest {

    @Test
    @DisplayName("금액별 로또 생성 갯수 테스트")
    void lotto_생성_개수(){
        assertThat(LottoMachine.getTicketsCount(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 당첨 갯수 테스트")
    void lotto_당첨_개수(){
        LottoTicket lotto = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        lotto.compareWithWinningNumbers(Arrays.asList(4,5,6,7,8,9));
        assertThat(lotto.getWinningCount()).isEqualTo(3);
    }
}
