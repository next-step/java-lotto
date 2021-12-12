package lotto.domain;

import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    private CreationLottoNumber creationLottoNumber;

    @BeforeEach
    void setUp(){
        creationLottoNumber = () -> new Lotto("1,2,3,4,5,6").getLottoNumbers();
    }

    @Test
    public void 생성_확인(){
        Lottos lottos = Lottos.of(1, creationLottoNumber);
        assertThat(lottos.getLottos().contains(new Lotto("1,2,3,4,5,6"))).isTrue();
    }

    @Test
    public void 상금_자동_로또번호(){
        List<Lotto> lottoGroup = Arrays.asList(
            new Lotto("1,2,3,4,5,6"),
            new Lotto("1,2,3,4,5,16"),
            new Lotto("1,2,3,4,5,7")
        );
        Lottos lottos = new Lottos(lottoGroup);

        List<LottoResult> lottoResultGroup = Arrays.asList(new LottoResult[]{
                  new LottoResult(Rank.FIFTH, 0)
                , new LottoResult(Rank.FOURTH, 0)
                , new LottoResult(Rank.THIRD, 1)
                , new LottoResult(Rank.SECOND, 1)
                , new LottoResult(Rank.FIRST, 1)
        });
        LottoResults lottoResults = new LottoResults(lottoResultGroup);
        assertThat(lottos.getResults(new PrizeLotto("1,2,3,4,5,6", "7"))).isEqualTo(lottoResults);
    }

    @Test
    public void 꽝_자동_로또번호(){
        List<Lotto> lottoGroup = Arrays.asList(
            new Lotto("31,32,33,34,35,36"),
            new Lotto("1,32,33,34,35,36"),
            new Lotto("1,2,33,34,35,37")
        );
        Lottos lottos = new Lottos(lottoGroup);

        List<LottoResult> lottoResultGroup = Arrays.asList(new LottoResult[]{
                  new LottoResult(Rank.FIFTH, 0)
                , new LottoResult(Rank.FOURTH, 0)
                , new LottoResult(Rank.THIRD, 0)
                , new LottoResult(Rank.SECOND, 0)
                , new LottoResult(Rank.FIRST, 0)
        });
        LottoResults lottoResults = new LottoResults(lottoResultGroup);
        assertThat(lottos.getResults(new PrizeLotto("1,2,3,4,5,6", "7"))).isEqualTo(lottoResults);
    }
}
