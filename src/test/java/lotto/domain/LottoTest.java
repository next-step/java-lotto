package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    public void 로또_생성_개수_비교(){
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 우승_로또번호_비교(){
        Lotto winLotto = new Lotto("1,2,3,4,5,6");

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.matchCountLotto(winLotto.getLottoNumbers())).isEqualTo(6);
    }
}
