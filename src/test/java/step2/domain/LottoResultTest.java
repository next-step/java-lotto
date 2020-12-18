package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("당첨 갯수 통계 테스트")
    @Test
    public void countRankTest(){
        Map<String,Object> result = new HashMap<>();
        List<WinningRank> winningRankList = new ArrayList<>();

        winningRankList.add(WinningRank.FOURTH);
        winningRankList.add(WinningRank.FOURTH);
        winningRankList.add(WinningRank.FOURTH);
        result.put("winningRanks",winningRankList);

        LottoResult lottoResult = new LottoResult(result);
        assertThat(lottoResult.countRank(WinningRank.FOURTH)).isEqualTo(3);
    }
}
