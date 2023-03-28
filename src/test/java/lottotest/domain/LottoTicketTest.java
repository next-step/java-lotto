package lottotest.domain;

import lotto.domain.LottoTicket;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 사이즈 확인")
    public void checkLottoSize(){
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1,2,3,4,5,6,7)));
    }

    @Test
    @DisplayName("로또 중복 확인")
    public void checkLottoDup(){
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1,2,3,4,6,6)));
    }

    @Test
    @DisplayName("로또 번호 정합성 확인")
    public void checkLottoNumberValid(){
        AssertionsForClassTypes.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoTicket(List.of(1,2,3,4,6,500)));
    }
}