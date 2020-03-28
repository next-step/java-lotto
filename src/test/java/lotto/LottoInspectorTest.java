package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInspectorTest {

    private WinningLotto testWinningLotto;
    private List<Lotto> testLottos;

    @BeforeEach
    void setting() {
        this.testWinningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        this.testLottos = new ArrayList<>();

        Lotto lotto1 = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
        Lotto lotto2 = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(41), new LottoNumber(42), new LottoNumber(43)
        ));
        this.testLottos.add(lotto1);
        this.testLottos.add(lotto2);
    }

    @Test
    @DisplayName("로또 분석기 생성 테스트")
    void createLottoInspectorTest() {
        assertThat(new LottoInspector(testWinningLotto, testLottos));
    }

    @Test
    @DisplayName("로또 분석후 수익금 가져오기 테스트")
    void getTotalRevenueTest() {
        assertThat(
                new LottoInspector(testWinningLotto, testLottos).getTotalRevenue()
        ).isEqualTo(RewardEnum.SIX.getReward() + RewardEnum.THREE.getReward());
    }
}
