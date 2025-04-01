package domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStaticsTest {
    private List<Lotto> lottoList;
    private List<Integer> winningNums;
    private LottoStatics lottoStatics;

    @BeforeEach
    void setUp() {
        lottoList = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)),   // 3개 일치
            new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),   // 4개 일치
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),   // 5개 일치
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))    // 6개 일치
        );

        winningNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoStatics = new LottoStatics(lottoList, winningNums);
    }

    @Test
    void 당첨_3개_4개_5개_6개_카운팅_테스트() {
        assertThat(lottoStatics.getHit3Count()).isEqualTo(1);
        assertThat(lottoStatics.getHit4Count()).isEqualTo(1);
        assertThat(lottoStatics.getHit5Count()).isEqualTo(1);
        assertThat(lottoStatics.getHit6Count()).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트() {
        assertThat(lottoStatics.getProfitRate()).isEqualTo("500051.25");
    }

    @Test
    void 수익률이_1_이상이면_isProfit_true() {
        LottoStatics highProfitStatics = new LottoStatics(
            Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
            winningNums
        );

        assertThat(highProfitStatics.isProfit()).isTrue();
    }
}
