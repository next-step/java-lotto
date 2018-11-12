package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameResultTest {

    private LottoGameResult lottoGameResult;
    private List<Lotto> lottos;

    @Before
    public void setUp() throws Exception {
        lottoGameResult = new LottoGameResult();
        lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        lottos.add(new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)));
    }

    @Test
    public void 게임결과얻기_3개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, Arrays.asList(1,2,3,4,5,6));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(0);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(5000);
    }

    @Test
    public void 게임결과얻기_4개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, Arrays.asList(32,38,2,4,13,6));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(1);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(50000);
    }

    @Test
    public void 게임결과얻기_5개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, Arrays.asList(5,9,38,41,43,6));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(2);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(1500000);
    }

    @Test
    public void 게임결과얻기_6개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, Arrays.asList(23, 25, 33, 36, 39, 41));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(3);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(2000000000);
    }

    @Test
    public void 게임결과_수익률_얻기() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        lottoDtos.add(new LottoDto(3, 5000,1, 5000));
        String ratio = lottoGameResult.getRatio(lottoDtos, 14000);
        assertThat(ratio).isEqualTo("0.36");
    }
}