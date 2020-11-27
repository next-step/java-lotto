package lotto;

import lotto.model.Lotto;
import lotto.model.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
}
