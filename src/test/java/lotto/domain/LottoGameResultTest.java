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
        lottos.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)));
        lottos.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        lottos.add(new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)));
        lottos.add(new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)));
        lottos.add(new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)));
        lottos.add(new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)));
        lottos.add(new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44)));
    }

    @Test
    public void 게임결과얻기_3개_일치() {
        LottoDto lottoDto = lottoGameResult.getLottoResultForThree(lottos, Arrays.asList(1,2,3,4,5,6));

        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(5000);
    }

    @Test
    public void 게임결과얻기_4개_일치() {
        LottoDto lottoDto = lottoGameResult.getLottoResultForFour(lottos, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoDto.getMatchNumber()).isEqualTo(0);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(0);
    }

    @Test
    public void 게임결과얻기_5개_일치() {
        LottoDto lottoDto = lottoGameResult.getLottoResultForFive(lottos, Arrays.asList(1,2,3,4,5,6));

        assertThat(lottoDto.getMatchNumber()).isEqualTo(0);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(0);
    }

    @Test
    public void 게임결과얻기_6개_일치() {
        LottoDto lottoDto = lottoGameResult.getLottoResultForSix(lottos, Arrays.asList(1,2,3,4,5,6));

        assertThat(lottoDto.getMatchNumber()).isEqualTo(0);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(0);
    }

    @Test
    public void 게임결과_수익률_얻기() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        lottoDtos.add(new LottoDto(3, 1, 5000));
        String ratio = lottoGameResult.getRatio(lottoDtos, 14000);
        assertThat(ratio).isEqualTo("0.36");
    }
}