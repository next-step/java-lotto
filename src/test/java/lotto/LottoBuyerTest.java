package lotto;

import lotto.model.WinningRecord;
import lotto.service.LottoBuyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBuyerTest {

    @Test
    @DisplayName("가진 금액으로 로또를 구매할 수 있는지 확인하는 테스트")
    public void checkCanBuyLotto() {
        assertThatThrownBy(() -> LottoBuyer.checkCanBuyLotto(10000, 11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매할 수 있는 로또의 최대 개수를 초과하였습니다.");
    }

    @Test
    @DisplayName("구매 가능한 자동로또 개수 계산 테스트")
    public void calculateAutoLottoCount() {
        assertThat(LottoBuyer.calculateAutoLottoCount(10000, 3)).isEqualTo(7);
    }

    @Test
    @DisplayName("로또 수동 구매 테스트")
    public void buyManualLotto() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        
        assertThat(lottoBuyer.buyManualLotto(new ArrayList<>(List.of(1, 5, 20, 35, 41, 22))))
                .isEqualTo(lottoBuyer.getBoughtLottos().get(0).getIntegerTypeNumbers());
    }

    @Test
    @DisplayName("로또 자동 구매 테스트")
    public void buyAutoLotto() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        
        assertThat(lottoBuyer.buyAutoLotto())
                .isEqualTo(lottoBuyer.getBoughtLottos().get(0).getIntegerTypeNumbers());
    }

    @Test
    @DisplayName("로또 결과 확인 테스트")
    public void checkLottoResult() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        
        lottoBuyer.buyManualLotto(new ArrayList<>(List.of(1, 3, 5, 7, 9, 11)));
        lottoBuyer.buyManualLotto(new ArrayList<>(List.of(2, 4, 6, 8, 10, 12)));

        Map<Integer, WinningRecord> winningStatistics = lottoBuyer.checkLottoResult("1, 2, 3, 4, 5, 6", 7);

        assertThat(winningStatistics.get(1).getWinningCount()).isEqualTo(0);
        assertThat(winningStatistics.get(2).getWinningCount()).isEqualTo(0);
        assertThat(winningStatistics.get(3).getWinningCount()).isEqualTo(0);
        assertThat(winningStatistics.get(4).getWinningCount()).isEqualTo(0);
        assertThat(winningStatistics.get(5).getWinningCount()).isEqualTo(2);
        assertThat(winningStatistics.get(0).getWinningCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("총 수익률 계산 테스트")
    public void calculateReturnRate() {
        LottoBuyer lottoBuyer = new LottoBuyer();
        
        lottoBuyer.buyManualLotto(new ArrayList<>(List.of(1, 3, 5, 7, 9, 11)));
        lottoBuyer.buyManualLotto(new ArrayList<>(List.of(2, 4, 6, 8, 10, 12)));

        Map<Integer, WinningRecord> winningStatistics = lottoBuyer.checkLottoResult("1, 2, 3, 4, 5, 6", 7);

        assertThat(lottoBuyer.checkReturnRate(10000, winningStatistics)).isEqualTo(1.0f);
    }

}