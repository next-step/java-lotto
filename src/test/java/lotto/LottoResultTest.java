package lotto;

import lotto.lotto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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
    void 로또_일치하는_맷칭_개수_저장() {
        LottoResult result = new LottoResult(lottos);
        LottoWinning winning = new LottoWinning("1, 2, 3, 4, 5, 10", 10);

        result.calculateLotto(winning);

        assertThat(result.getResultMap().get(LottoRank.RANK_ONE)).isEqualTo(3);

        winning = new LottoWinning("1, 2, 3, 4, 5, 33", 10);

        result.calculateLotto(winning);

        assertThat(result.getResultMap().get(LottoRank.RANK_ONE)).isEqualTo(3);
        assertThat(result.getResultMap().values().stream().filter(value -> value == 0).count()).isEqualTo(3);
        assertThat(result.getResultMap().values().stream().filter(value -> value == 3).count()).isEqualTo(2);
    }

}
