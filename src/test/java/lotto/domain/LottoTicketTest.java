package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void init() {
        lottoTicket = new LottoTicket(new RandomNumberCreation());
    }

    @Test
    void constructor_정상() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        //when

        //then
        assertDoesNotThrow(() -> {
            new LottoTicket(lottoNumbers);
        });
    }

    @Test
    void constructor_예외() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        //when

        //then
        assertThatThrownBy(() -> {
            new LottoTicket(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6자리입니다.");
    }

    @Test
    void calculateSameNumberCount() throws Exception {
        //given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket otherLottoTicket =
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9));
        this.lottoTicket = new LottoTicket(lottoNumbers);


        //when
        int count = this.lottoTicket.calculateSameNumberCount(otherLottoTicket);

        //then
        assertThat(count).isEqualTo(4);
    }
}
