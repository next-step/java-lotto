package study.step3.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.LottoResult;
import study.step3.domain.WinningRank;
import study.step3.domain.WinningRanks;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 갯수 통계 테스트")
    @Test
    public void countRankTest(){
        List<WinningRank> winningRanks = new ArrayList<>();
        winningRanks.add(WinningRank.FOURTH);
        winningRanks.add(WinningRank.FOURTH);
        winningRanks.add(WinningRank.FOURTH);

        LottoResult lottoResult =  new LottoResult(new WinningRanks(winningRanks));

        assertThat(lottoResult.countRank(WinningRank.FOURTH)).isEqualTo(3);
    }
}
