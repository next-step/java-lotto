package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    public void 로또들이_주어졌을_때_동등성_확인을_할_수_있다(){
        //given
        LottoTicket lottoTicket = new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6))));
        //when
        //then
        assertThat(lottoTicket).isEqualTo(new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6)))));
    }

    @Test
    public void 로또티켓_생성_시_null이거나_원소가_6개가_아니면_익셉션이_발생한다(){
        //given
        //when
        //then
        assertThatThrownBy(() -> new LottoTicket(new ArrayList<>(Collections.singletonList(new LottoNumber(1)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 지난 주 당첨 번호입니다.");
    }

    @Test
    public void 로또티켓에서_원소를_포함하고있음을_확인할_수_있다(){
        //given
        LottoTicket lottoTicket = new LottoTicket(new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
                new LottoNumber(6))));
        //when
        boolean result = lottoTicket.contains(new LottoNumber(3));
        //then
        assertThat(result).isTrue();
    }
}
