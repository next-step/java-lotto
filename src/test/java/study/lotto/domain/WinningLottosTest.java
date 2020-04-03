package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottosTest {
    @DisplayName("등수에 맞는 로또를 추가한다.")
    @Test
    void addRank() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        ;
        WinningLottos winningLottos = new WinningLottos();
        winningLottos.addToRank(LottoRank.FIRST, new Lotto(lottoNumbers));
        assertThat(winningLottos.size(LottoRank.FIRST)).isEqualTo(1);
    }

    @DisplayName("아무것도 추가하지 않으면 모든 등수는 0이다.")
    @Test
    void init() {
        WinningLottos winningLottos = new WinningLottos();
        for (LottoRank lottoRank : LottoRank.values()) {
            assertThat(winningLottos.size(lottoRank)).isEqualTo(0);
        }
    }


}
