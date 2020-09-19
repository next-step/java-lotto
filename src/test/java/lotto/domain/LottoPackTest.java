package lotto.domain;

import lotto.common.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPackTest {

    @DisplayName("로또패키지 생성")
    @Test
    void newInstance() {
        //given
        int lottoPrice = 1_000;
        List<LottoTicket> lottoTickets = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(LottoNumber::new)
                .collect(collectingAndThen(toSet()
                        , lottoNumbers -> Collections.singletonList(new LottoTicket(lottoNumbers))));

        //when
        LottoPack lottoPack = new LottoPack(lottoPrice, lottoTickets);

        //then
        assertThat(lottoPack).isNotNull();
    }

    @DisplayName("당첨번호 일치 개수 결과 확인")
    @Test
    void matchResult() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 7";
        int lottoPrice = 1_000;

        List<LottoTicket> lottoTickets = Stream.iterate(1, n -> n + 1)
                .limit(6)
                .map(LottoNumber::new)
                .collect(collectingAndThen(toSet()
                        , lottoNumbers -> Collections.singletonList(new LottoTicket(lottoNumbers))));

        LottoPack lottoPack = new LottoPack(lottoPrice, lottoTickets);

        //when
        LottoMatchResult matchResult = lottoPack.matchResult(winningNumbers);

        //then
        Map<LottoRank, Integer> matchResultMap = new HashMap<>();
        matchResultMap.put(LottoRank.SECOND, 1);
        LottoMatchResult expected = new LottoMatchResult(matchResultMap, 1_500);

        assertEquals(expected, matchResult);
    }
}