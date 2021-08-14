package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.model.Lotto.NUMBER_COUNT;
import static lotto.model.WinningRank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 순위 테스트")
public class WinningRankTest {

    @DisplayName("당첨 순위 목록을 찾는 기능이 정상 동작해야 한다.")
    @Test
    public void findWinningRanksTest() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < 8; index++) {
            List<LottoNumber> lottoNumbers = LottoNumber.getAllLottoNumbers().subList(index, index + NUMBER_COUNT);
            lottos.add(new Lotto(() -> lottoNumbers));
        }

        LottoNumber bonusNumber = LottoNumber.valueOf(1);
        Lotto winningNumbers = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        DrawNumbers drawNumbers = new DrawNumbers(winningNumbers, bonusNumber);

        // when, then
        assertThat(WinningRank.findWinningRanks(new Lottos(lottos), drawNumbers))
                .containsExactly(SECOND_PLACE, FIRST_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE, MISS, MISS, MISS);
    }
}
