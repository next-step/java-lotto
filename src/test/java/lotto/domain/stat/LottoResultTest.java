package lotto.domain.stat;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoResultTest {

    private Lottos lottos;
    private Lotto winningLotto;
    private Money money;

    @BeforeEach
    void init() {
        List<LottoNumber> lottoNumberList = IntStream.range(1, 12)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Lotto lotto1 = new Lotto(lottoNumberList.subList(0, 6));
        Lotto lotto2 = new Lotto(lottoNumberList.subList(1, 7));
        Lotto lotto3 = new Lotto(lottoNumberList.subList(2, 8));
        Lotto lotto4 = new Lotto(lottoNumberList.subList(3, 9));
        Lotto lotto5 = new Lotto(lottoNumberList.subList(4, 10));
        Lotto lotto6 = new Lotto(lottoNumberList.subList(5, 11));

        lottos = new Lottos(Arrays.asList(
                lotto1,
                lotto2,
                lotto3,
                lotto4,
                lotto5,
                lotto6
        ));

        winningLotto = new Lotto(lottoNumberList.subList(2, 8));

        money = new Money(6000);
    }

    @Test
    void generate() {
        LottoResult result = LottoResult.generate(lottos, winningLotto, money);

        LottoRankCountMap lottoRankCountMap = result.getRankCountMap();
        Money totalReward = result.getTotalReward();
        double profitRate = result.getProfitRate();

        assertEquals(new Money(2003105000), totalReward);
        assertEquals(2003105000.0 / 6000, profitRate);
        assertEquals(1, lottoRankCountMap.get(LottoRank.FIRST));
        assertEquals(2, lottoRankCountMap.get(LottoRank.SECOND));
        assertEquals(2, lottoRankCountMap.get(LottoRank.THIRD));
        assertEquals(1, lottoRankCountMap.get(LottoRank.FOURTH));
        assertEquals(0, lottoRankCountMap.get(LottoRank.NONE));
    }

}
