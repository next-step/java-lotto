package lotto.domain;

import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import lotto.domain.purchaseStrategy.PurchaseStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoMachineTest {

    private LottoMachine lottoMachine;
    private PurchaseStrategy purchaseStrategy = new AutoPurchaseStrategy();

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("지불금액이 천원 이하일때 예외 throw")
    @Test
    void buyLotto_1000원_이하() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoMachine.buyLotto(999, purchaseStrategy);
        }).withMessageMatching("최소 1000원 이상 지불하셔야 합니다.");
    }

    @DisplayName("등수정보를 가져온다.")
    @Test
    void makeStatisticsWinnings_등수정보() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("5,10,15,20,25,30"),
                        new Lotto("5,10,15,20,25,1"),
                        new Lotto("5,10,15,20,1,2"),
                        new Lotto("5,10,15,1,2,3"),
                        new Lotto("5,10,1,2,3,4"),
                        new Lotto("1,2,3,4,6,7")
                )
        );
        Lotto winningLotto = new Lotto("5,10,15,20,25,30");
        Map<Rank, MatchingCount> winnings = lottoMachine.makeStatisticsWinnings(lottos, winningLotto);

        assertThat(winnings.get(Rank.FIRST)).isEqualTo(new MatchingCount(1));
        assertThat(winnings.get(Rank.SECOND)).isEqualTo(new MatchingCount(1));
        assertThat(winnings.get(Rank.THIRD)).isEqualTo(new MatchingCount(1));
        assertThat(winnings.get(Rank.FOURTH)).isEqualTo(new MatchingCount(1));
        assertThat(winnings.get(Rank.MISS)).isEqualTo(new MatchingCount(2));
    }

    @DisplayName("수익률을 가져온다.")
    @Test
    void calculateEarningsRate_수익률() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto("5,10,15,20,1,2"),
                        new Lotto("5,10,15,1,2,3"),
                        new Lotto("5,10,1,2,3,4"),
                        new Lotto("1,2,3,4,6,7")
                )
        );
        Lotto winningLotto = new Lotto("5,10,15,20,25,30");
        Map<Rank, MatchingCount> winnings = lottoMachine.makeStatisticsWinnings(lottos, winningLotto);

        assertThat(lottoMachine.calculateEarningsRate(winnings, 4)).isEqualTo(13.75);

    }

}
