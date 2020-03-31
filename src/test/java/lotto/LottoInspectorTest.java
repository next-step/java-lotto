package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoInspectorTest {

    private Lotto testWinningLotto;
    private LottoNumber testBonusNumber;
    private List<Lotto> testLottos;
    private LottoInspector lottoInspector;

    @BeforeEach
    void setting() {
        this.lottoInspector = new LottoInspector();
        this.testWinningLotto = Lotto.newManual("1, 2, 3, 4, 5, 6");
        this.testBonusNumber = LottoNumber.newChooseNumber(7);
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
    @DisplayName("로또 분석후 수익금 가져오기 테스트")
    void getTotalRevenueTest() {
        Map<RankEnum, Integer> result = this.lottoInspector.getResult(testWinningLotto, testBonusNumber, testLottos);

        assertThat(
                new LottoInspector().getTotalRevenue(result)
        ).isEqualTo(RankEnum.FIRST.getReward() + RankEnum.FIFTH.getReward());
    }

    @Test
    @DisplayName("수익률 가져오기 테스트")
    void getYieldTest() {
        assertThat(
                this.lottoInspector.getYield(new Money(1000), 5000)
        ).isEqualByComparingTo(new BigDecimal(5));
    }
}
