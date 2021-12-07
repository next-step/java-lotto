package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private List<Lotto> lottoGroup;
    private Lottos lottos;

    @BeforeEach
    void setUp(){
        lottoGroup = new ArrayList<>();
        lottoGroup.add(new Lotto("1,2,3,4,5,6"));
        lottoGroup.add(new Lotto("1,2,3,4,5,7"));
        lottos = new Lottos(lottoGroup);
    }

    @Test
    public void 로또_개수확인(){
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

    @Test
    public void 값비교(){
        Lotto winLotto = new Lotto("1,2,3,4,5,6");
        List<Rank> ranks = lottos.compareWinLotto(winLotto);
        assertThat(ranks.stream().findFirst().get().getMatchCount()).isEqualTo(6);
    }
}
