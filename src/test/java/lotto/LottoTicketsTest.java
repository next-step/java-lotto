package lotto;

import lotto.model.LottoNumber;
import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    LottoTicket winningTicket;

    @BeforeEach
    void before(){
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        List<LottoNumber> lottoNumbers = Arrays.stream(nums)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        winningTicket = new LottoTicket(lottoNumbers);
    }

    @Test
    @DisplayName("몇개 일치하는지 테스트")
    void 일치_수_테스트(){
        Integer[] nums = {1, 2, 3, 4, 10, 11}; // 4
        LottoTicket lottoTicket1 = new LottoTicket(Arrays.stream(nums)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        Integer[] nums2 = {1, 2, 3, 10, 11, 12}; // 3
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.stream(nums2)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(lottoTicket1);
        lottoTicketList.add(lottoTicket2);

        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        Map<Rank, Long> res = lottoTickets.getRankMap(winningTicket);
        assertThat(res.get(Rank.three)).isEqualTo(1);
        assertThat(res.get(Rank.four)).isEqualTo(1);
        assertThat(res.get(Rank.five)).isEqualTo(null);
        assertThat(res.get(Rank.six)).isEqualTo(null);
    }
    
}
