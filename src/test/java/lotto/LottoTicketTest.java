package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 1장 생성 테스트")
    public void lottoMake(){
        LottoTicket lottoTicket = LottoTicket.lottoMake();
        assertThat(lottoTicket.getTicket()).hasSize(6);
    }

    @Test
    @DisplayName("당첨번호 맞힌 개수 테스트")
    public void lottoNumberMatchCount(){
        LottoTicket lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6));
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        assertThat(lottoTicket.lottoNumberMatchCount(winningNumbers)).isEqualTo(6);
    }

    @Test
    @DisplayName("빈값 테스트")
    public void lottoMakeNullPointException(){
        assertThatThrownBy(() -> new LottoTicket(new ArrayList<>()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("로또가 생성 되지 않았습니다.");
    }
}
