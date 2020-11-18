package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @DisplayName("LottoTicket 랜덤 번호 생성 테스트")
    @Test
    void lottoTicketRandomNumberCreateTest(){
        LottoTicket lottoTicket = new LottoTicket();

        assertThat(lottoTicket.getSortedLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("LottoTicket 번호 오름차순으로 조회되는지 테스트")
    @Test
    void getLottoTicketSortedNumberTest(){
        //given
        List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());

        //when
        LottoTicket lottoTicket = new LottoTicket();

        int min = lottoTicket.getSortedLottoNumbers()
                .stream()
                .mapToInt(v -> v)
                .min().orElseThrow(NoSuchElementException::new);

        // then
        assertThat(min).isEqualTo(lottoTicket.getSortedLottoNumbers().get(0));
    }
}
