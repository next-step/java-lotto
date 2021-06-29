package lottoAuto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private boolean hasBonusBall;

    @Test
    public void containBonusBall(){
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);

        lottos.stream()
                .forEach(x -> this.hasBonusBall = x.hasBonusBall(3));

        assertThat(true).isEqualTo(hasBonusBall);
    }
}
