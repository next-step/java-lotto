package lottotest.domain;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @Test
    @DisplayName("로또 사이즈 확인")
    public void checkLottoSize(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {lottoTicket = new LottoTicket(List.of(1,2,3,4,5,6,7));}
                ).withMessageContaining("로또 번호가 6자리가 아닙니다.");
    }

    @Test
    @DisplayName("로또 중복 확인")
    public void checkLottoDup(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {lottoTicket = new LottoTicket(List.of(1,2,3,4,6,6));}
                ).withMessageContaining("중복된 번호를 사용할 수 없습니다.");
    }

    @Test
    @DisplayName("로또 번호 정합성 확인")
    public void checkLottoNumberValid(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {lottoTicket = new LottoTicket(List.of(1,2,3,4,6,500));}
                ).withMessageContaining("1~45 사이의 번호가 아닙니다.");
    }
}