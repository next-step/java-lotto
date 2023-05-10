package lottoauto.domain;

import lottoauto.model.WinningReward;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningRewardTest {

    @Test
    void 값으로_enum_출력_테스트() {
        int match = 3;
        WinningReward rewardByMatches = WinningReward.findRewardByMatches(match);

        Assertions.assertThat(rewardByMatches).isEqualTo(WinningReward.MATCH_3);
    }

}
