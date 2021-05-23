package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.enums.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "25000:25", "12500:12"}, delimiter = ':')
    void 입력된_구입금액_기준_로또_구매_기능_테스트(int value, int excepted) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.buyAutoLottos(new LottoPayment(value));
        assertThat(lottoStore.lottos().size()).isEqualTo(excepted);
    }

    @Test
    void 구매한_로또_당첨_결과_계산_테스트() {
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,7"),
                new Lotto("1,2,3,4,7,8"),
                new Lotto("1,2,3,7,8,9"),
                new Lotto("1,2,7,8,9,10")
        );
        LottoStore lottoStore = new LottoStore(lottos);
        WinningRanks excepted = new WinningRanks(Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH));

        WinningRanks ranks = lottoStore.calcLottosRank(winningLotto);
        assertThat(ranks).isEqualTo(excepted);
    }
}
