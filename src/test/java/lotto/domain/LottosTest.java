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
    public void 자동로또번호(){
        List<Lotto> lottoGroup = new ArrayList<>();
        lottoGroup.add(new Lotto("1,2,3,4,5,6"));
        lottoGroup.add(new Lotto("1,2,3,4,5,16"));
        Lottos lottos = new Lottos(lottoGroup);
        List<LottoResult> lottoResults = Arrays.asList(new LottoResult[]{
                new LottoResult(Rank.valueOf(3), 0)
                , new LottoResult(Rank.valueOf(4), 0)
                , new LottoResult(Rank.valueOf(5), 1)
                , new LottoResult(Rank.valueOf(6), 1)
        });
        assertThat(lottos.getResult(new Lotto("1,2,3,4,5,6"))).isEqualTo(lottoResults);
    }
}
