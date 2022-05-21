package lotto;

import lotto.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    LottoTicket winningTicket;

    @BeforeEach
    void before(){
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        List<LottoNumber> lottoNumbers = Arrays.stream(nums)
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        winningTicket = new LottoTicket(lottoNumbers);
    }

    @Test
    @DisplayName("몇개 일치하는지 테스트")
    void 일치_수_테스트(){
        Integer[] nums = {1, 2, 3, 4, 10, 11}; // 4
        LottoTicket lottoTicket1 = new LottoTicket(nums);

        Integer[] nums2 = {1, 2, 3, 10, 11, 12}; // 3
        LottoTicket lottoTicket2 = new LottoTicket(nums2);

        LottoTickets lottoTickets = new LottoTickets(List.of(lottoTicket1), List.of(lottoTicket2));

        LottoNumber bonusBall = new LottoNumber(44);
        LottoResult lottoResult = lottoTickets.getRankMap(winningTicket, bonusBall);

        Map<Rank, Long> result = Map.ofEntries(
                entry(Rank.FIRST, 0L),
                entry(Rank.SECOND, 0L),
                entry(Rank.THIRD, 0L),
                entry(Rank.FIFTH, 1L),
                entry(Rank.FOURTH, 1L)
        );

        assertThat(lottoResult.getRankTreeMap()).containsExactlyInAnyOrderEntriesOf(result);
    }

    @Test
    @DisplayName("몇개 일치하는지 테스트")
    void 로또_티켓들_생성_예외_테스트() {
        LottoTicket lottoTicket1 = new LottoTicket(new Integer[]{1, 2, 3, 4, 10, 11});
        assertThatThrownBy(()->{
            new LottoTickets(null, List.of(lottoTicket1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
