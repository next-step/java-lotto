package domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticsTest {

    @Test
    void 당첨_3개_4개_5개_6개_카운팅_테스트() {
        List<Lotto> lottoList = this.createLottoListWithRank(createWinningNum());
        LottoStatics lottoStatics = new LottoStatics(lottoList);

        assertThat(lottoStatics.getFifthCount()).isEqualTo(1);
        assertThat(lottoStatics.getFourthCount()).isEqualTo(1);
        assertThat(lottoStatics.getSecondCount()).isEqualTo(1);
        assertThat(lottoStatics.getFirstCount()).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트() {
        List<Lotto> lottoList = this.createLottoListWithRank(createWinningNum());
        LottoStatics lottoStatics = new LottoStatics(lottoList);

        assertThat(lottoStatics.getProfitRate()).isEqualTo("507513.75");
    }

    @Test
    void 수익률이_1_이상이면_isProfit_true() {
        LottoStatics highProfitStatics = new LottoStatics(
            List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6),
                    createWinningNum(),
                    new BonusNumber(7)
                ))
        );

        assertThat(highProfitStatics.isProfit()).isTrue();
    }

    private List<Lotto> createLottoListWithRank(List<Integer> winningNums) {
        List<Lotto> lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        for (Lotto lotto : lottoList) {
            lotto.matchRank(winningNums, new BonusNumber(9));
        }

        return lottoList;
    }

    private List<Integer> createWinningNum() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
