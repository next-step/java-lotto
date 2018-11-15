package lotto.domain;

import lotto.enums.Rank;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoGeneratorResultTest {

    private LottoGameResult lottoGameResult;
    private BundleLotto lottos;

    @Before
    public void setUp() throws Exception {
        lottoGameResult = new LottoGameResult();
        lottos = new BundleLotto();

        lottos.addLotto(Lotto.manual("1, 3, 5, 14, 22, 45"));
        lottos.addLotto(Lotto.manual("2, 13, 22, 32, 38, 45"));
        lottos.addLotto(Lotto.manual("5, 9, 38, 41, 43, 44"));
        lottos.addLotto(Lotto.manual("39, 7, 40, 27, 26, 21"));
        lottos.addLotto(Lotto.manual("23, 25, 33, 36, 39, 41"));
    }

    @Test
    public void 게임결과얻기_3개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, new WinningLotto("1, 2, 3, 4, 5, 6", 7));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(0);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(5000);
    }

    @Test
    public void 게임결과얻기_4개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, new WinningLotto("32,38,2,4,13,6", 7));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(1);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(50000);
    }

    @Test
    public void 게임결과얻기_5개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, new WinningLotto("5,9,38,41,43,6", 45));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(2);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(1500000);
    }

    @Test
    public void 게임결과얻기_5개_보너스_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, new WinningLotto("39, 7, 40, 27, 6, 10", 26));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(3);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(30000000);
    }

    @Test
    public void 게임결과얻기_6개_일치() {
        lottoGameResult.doCalculateLottoResult(lottos, new WinningLotto("23, 25, 33, 36, 39, 41", 7));

        LottoDto lottoDto = lottoGameResult.getLottoDtos().get(4);
        assertThat(lottoDto.getMatchNumber()).isEqualTo(1);
        assertThat(lottoDto.getWinningMoney()).isEqualTo(2000000000);
    }

    @Test
    public void 게임결과_수익률_얻기() {
        List<LottoDto> lottoDtos = new ArrayList<>();
        lottoDtos.add(new LottoDto(Rank.FIFTH, 1, 5000));
        String ratio = lottoGameResult.getRatio(lottoDtos, new LottoCountManager(14000, 3));
        assertThat(ratio).isEqualTo("0.36");
    }
}