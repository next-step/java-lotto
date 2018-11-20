package lotto.service;


import lotto.dto.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @Before
    public void init(){
        Map<Rank,Integer> maps = Stream.of(Rank.values())
                .collect(Collectors.toMap(
                        e -> e
                        ,e -> 1
                        )
                );
        lottoResult = new LottoResult(1000,maps);
    }

    @Test
    public void 이익테스트() {
        assertThat(lottoResult.getProfitMessage(0.4)).isEqualTo("손해");
    }

    @Test
    public void 손해테스트() {
        assertThat(lottoResult.getProfitMessage(3000)).isEqualTo("이익");
    }

    @Test
    public void 이익금테스트() {
        Map<Rank,Integer> maps = Stream.of(Rank.values())
                .collect(Collectors.toMap(
                        e -> e
                        ,e -> 0
                    )
                );

        assertThat(lottoResult.profit()).isEqualTo(2031555.0);


    }
}
