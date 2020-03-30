package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInspectorTest {

    private Lotto testWinningLotto;
    private List<Lotto> testLottos;

    @BeforeEach
    void setting() {
        this.testWinningLotto = Lotto.newManual("1, 2, 3, 4, 5, 6");
        this.testLottos = new ArrayList<>();

        Lotto lotto1 = Lotto.newManual(Arrays.asList(
                LottoNumber.newChooseNumber(1), LottoNumber.newChooseNumber(2), LottoNumber.newChooseNumber(3), LottoNumber.newChooseNumber(4), LottoNumber.newChooseNumber(5), LottoNumber.newChooseNumber(6)
        ));
        Lotto lotto2 = Lotto.newManual(Arrays.asList(
                LottoNumber.newChooseNumber(1), LottoNumber.newChooseNumber(2), LottoNumber.newChooseNumber(3), LottoNumber.newChooseNumber(41), LottoNumber.newChooseNumber(42), LottoNumber.newChooseNumber(43)
        ));
        this.testLottos.add(lotto1);
        this.testLottos.add(lotto2);
    }

    @Test
    @DisplayName("로또 분석기 생성 테스트")
    void createLottoInspectorTest() {
        new LottoInspector(testWinningLotto, testLottos);
    }

    @Test
    @DisplayName("로또 분석후 수익금 가져오기 테스트")
    void getTotalRevenueTest() {
        assertThat(
                new LottoInspector(testWinningLotto, testLottos).getTotalRevenue()
        ).isEqualTo(RewardEnum.SIX.getReward() + RewardEnum.THREE.getReward());
    }

    @Test
    @DisplayName("수익률 가져오기 테스트")
    void getYieldTest() {
        assertThat(
                new LottoInspector(testWinningLotto, testLottos).getYield(new Money(1000), 5000)
        ).isEqualByComparingTo(new BigDecimal(5));
    }
}
