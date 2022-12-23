package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Reward;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {


    @Test
    @DisplayName("로또 1장에 개수가 6개가 아닐경우")
    public void lottoTicketNumberOver(){
            assertThatThrownBy(() -> new LottoTicket(List.of(1,2,3,4,5,6,7)))
                    .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 개수가 맞지않습니다");

    }

    @Test
    @DisplayName("당첨 등수 테스트")
    public void lottoReward(){
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1,2,3,4,5,6), 18);
        Reward reward = lottoTicket.lottoNumberMatch(winningNumbers);
        assertThat(reward.getRewordMoney()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("빈값 테스트")
    public void lottoMakeNullPointException(){
        assertThatThrownBy(() -> new LottoTicket(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("로또가 생성 되지 않았습니다.");
    }
}
