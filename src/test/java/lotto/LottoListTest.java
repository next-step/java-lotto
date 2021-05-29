package lotto;

import lotto.domain.Lotto;
import lotto.domain.entity.LottoList;
import lotto.domain.entity.Number;
import lotto.domain.RankCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoListTest {

    @Test
    @DisplayName("구매 금액이나 로또 여러장으로 LottoList 를 생성한다.")
    public void 로또_생성자_확인(){
        Lotto lotto1 = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Lotto lotto2 = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
        LottoList amountLotto = new LottoList(5);
        LottoList arrayLotto = new LottoList(lotto1, lotto2);
        assertThat(amountLotto.size()).isEqualTo(5);
        assertThat(arrayLotto.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 한장을 정상적으로 반환하는지 확인한다.")
    public void 로또_가져오기(){
        Lotto lotto = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        LottoList lottoList = new LottoList(lotto);
        assertThat(lottoList.get(0)).isEqualTo(lotto);
    }

    @Test
    @DisplayName("비교 결과가 정상적인지 확인한다.")
    public void 당첨_결과(){
        Lotto winningLotto = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Lotto lotto1 = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        Lotto lotto2 = new Lotto(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(7));
        LottoList lottoList = new LottoList(lotto1, lotto2);
        assertThat(lottoList.compareWith(winningLotto, new Number(5))).isEqualTo(makeRank());
    }

    private RankCounter makeRank(){
        RankCounter rankCounter = new RankCounter();
        rankCounter.addFirst();
        rankCounter.addSecond();
        return rankCounter;
    }
}
