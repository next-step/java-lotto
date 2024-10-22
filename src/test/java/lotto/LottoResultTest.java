package lotto;
import lotto.lotto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
class LottoResultTest {

    private List<LottoNumber> lottoNumbers;
    List<Lotto> lottos = new ArrayList<>();
    @BeforeEach
    void setUp() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(10));
        lottos.add(new Lotto(lottoNumbers));
        lottos.add(new Lotto(lottoNumbers));
        lottos.add(new Lotto(lottoNumbers));

    }
    @Test
    void 로또_맷칭_결과_계산() {
        LottoResult result = new LottoResult(lottos);
        LottoWinning winning = new LottoWinning("1, 2, 3, 4, 5, 10");

        result.calculateLotto(winning);

        assertThat(result.getResultMap().get(6)).isEqualTo(3);

        winning = new LottoWinning("1, 2, 3, 4, 5, 33");

        result.calculateLotto(winning);

        assertThat(result.getResultMap().get(5)).isEqualTo(3);

    }

}
