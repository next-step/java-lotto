package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step2_1.domain.LottoResult;
import study.step2_1.domain.WinningRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @DisplayName("당첨 갯수 통계 테스트")
    @Test
    public void countRankTest(){
        Map<String, Object> result = new HashMap<>();
        List<WinningRank> winningRanks = new ArrayList<>();
        winningRanks.add(WinningRank.FOURTH);
        winningRanks.add(WinningRank.FOURTH);
        winningRanks.add(WinningRank.FOURTH);
        result.put("winningRanks",winningRanks);

        LottoResult lottoResult =  new LottoResult(result);

        assertThat(lottoResult.countRank(WinningRank.FOURTH)).isEqualTo(3);
    }
}
