package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.LottoMoneyException;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 가격을 입력하면 갯수를 반환한다.")
    void create(){
        LottoFactory lottoTicket = new LottoFactory(14000);
        assertThat(lottoTicket.isLottoTicketsCount(14)).isTrue();
    }
    @Test
    @DisplayName("로또의 최소가격 미만으로 지불했을 경우 익셉션이 발생한다.")
    void exception(){
        assertThatThrownBy(() -> new LottoFactory(999))
                .isInstanceOf(LottoMoneyException.class);
    }
}
