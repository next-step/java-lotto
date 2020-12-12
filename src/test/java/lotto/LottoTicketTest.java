package lotto;


import lotto.model.LottoTicket;
import lotto.model.TicketType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    @Test
    @DisplayName("번호 개수 테스트")
    public void countOverTest(){
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoTicket.getTicketNumbers().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("번호 중복 테스트")
    public void duplicateTest(){

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1,3,5,7,3,9));
                }).withMessage("로또의 번호는 6개 이어야 합니다.");
    }

    @Test
    @DisplayName("잘못된 번호 입력 테스트")
    public void manualNumberTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    LottoTicket.of("1, 23, 37, 40 ,41 ,50");
                }).withMessage("로또 번호는 1~45 사이 입니다.");

    }

    @Test
    @DisplayName("로또 티켓 구분 테스트")
    public void typeTest(){
        List<Integer> autoTicket = Arrays.asList(1,2,3,4,5,6);
        LottoTicket lottoTicket = new LottoTicket(autoTicket, TicketType.AUTO);
        assertThat(lottoTicket.getTicketType().getTicketTypeName()).isEqualTo("자동");

        String manualTicket = "1,2,3,4,5,6";
        LottoTicket mTicket = LottoTicket.of(manualTicket);
        assertThat(mTicket.getTicketType().getTicketTypeName()).isEqualTo("수동");

    }
}
