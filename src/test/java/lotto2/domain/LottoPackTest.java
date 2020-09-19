package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

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
}