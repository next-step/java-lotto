package step3;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    private long totalPrize = 0;
    private Map<Integer, Integer> summaryResult = new HashMap<>();
    private Money money = new Money(10000);

    @BeforeEach
    void setUp() {
        LottoLottery.bonusWinningCount = 1;
        LottoLottery.bonusCheck = true;

        summaryResult.put(5, 2);
        summaryResult.put(3, 1);
        summaryResult.put(4, 2);

        for (int key : summaryResult.keySet()) {
            totalPrize += Prize.matchOfCount(key, false).getWinningMoney() * summaryResult.get(key);
        }

        summaryResult.put(5, 3);
        totalPrize += Prize.matchOfCount(5, true).getWinningMoney() * LottoLottery.bonusWinningCount;

    }

    @DisplayName("구매금액 입력 확인: 1000원 미만 불가")
    @Test
    public void 구매액수_확인() {

        assertThatIllegalArgumentException().isThrownBy(() -> Money.validateMoney(900));
    }

    @DisplayName("전체 상금 계산 확인")
    @Test
    public void 전체_상금_확인() {
        money.winningPrize(summaryResult);
        System.out.println("MoneyTest 에서 계산한 총 상금: " + this.totalPrize + ",");
        System.out.println("Money클래스에서 계산한 총 상금: " + money.getTotalPrize());

        assertThat(this.totalPrize).isEqualTo(money.getTotalPrize());
    }

}
