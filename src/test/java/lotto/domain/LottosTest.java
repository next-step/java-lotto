package lotto.domain;

import lotto.strategy.CreationAutoLottoNumber;
import lotto.strategy.CreationLottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    private CreationLottoNumber creationLottoNumber;

    @BeforeEach
    void setUp(){
        creationLottoNumber = new CreationAutoLottoNumber() {
            @Override
            public List<LottoNumber> automatic() {
            return new Lotto("1,2,3,4,5,6").getLottoNumbers();
            }
        };
    }

    @Test
    public void 생성_확인(){
        Lottos lottos = new Lottos(1, creationLottoNumber);
        assertThat(lottos.getLottos().contains(new Lotto("1,2,3,4,5,6"))).isTrue();
    }

    @Test
    public void 상금_자동_로또번호(){
        List<Lotto> lottoGroup = new ArrayList<>();
        lottoGroup.add(new Lotto("1,2,3,4,5,6"));
        lottoGroup.add(new Lotto("1,2,3,4,5,16"));
        lottoGroup.add(new Lotto("1,2,3,4,5,7"));
        Lottos lottos = new Lottos(lottoGroup);
        List<LottoResult> lottoResults = Arrays.asList(new LottoResult[]{
                new LottoResult(Rank.valueOf(3, false), 0)
                , new LottoResult(Rank.valueOf(4, false), 0)
                , new LottoResult(Rank.valueOf(5, false), 1)
                , new LottoResult(Rank.valueOf(5, true), 1)
                , new LottoResult(Rank.valueOf(6, false), 1)
        });
        assertThat(lottos.getResult(new PrizeLotto("1,2,3,4,5,6", "7"))).isEqualTo(lottoResults);
    }

    @Test
    public void 꽝_자동_로또번호(){
        List<Lotto> lottoGroup = new ArrayList<>();
        lottoGroup.add(new Lotto("31,32,33,34,35,36"));
        lottoGroup.add(new Lotto("1,32,33,34,35,36"));
        lottoGroup.add(new Lotto("1,2,33,34,35,37"));
        Lottos lottos = new Lottos(lottoGroup);
        List<LottoResult> lottoResults = Arrays.asList(new LottoResult[]{
                new LottoResult(Rank.valueOf(3, false), 0)
                , new LottoResult(Rank.valueOf(4, false), 0)
                , new LottoResult(Rank.valueOf(5, false), 0)
                , new LottoResult(Rank.valueOf(5, true), 0)
                , new LottoResult(Rank.valueOf(6, false), 0)
        });
        assertThat(lottos.getResult(new PrizeLotto("1,2,3,4,5,6", "7"))).isEqualTo(lottoResults);
    }
}
