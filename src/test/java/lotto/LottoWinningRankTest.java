package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningRankTest {
    @Test
    @DisplayName("당첨번호와 구입한 로또번호로 당첨타입을 확인한다.")
    void winningRank_test() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> boughtLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        String winningType = LottoWinningRank.getWinningRank(winningNumbers, boughtLottoNumbers);
        assertThat(winningType).isEqualTo("1등");
    }
}
