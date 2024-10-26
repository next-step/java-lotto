package lotto;

import lotto.model.WinningInfo;
import lotto.service.LottoBuyer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBuyerTest {
    private final LottoBuyer lottoBuyer = new LottoBuyer();

    @Test
    public void 가진_금액으로_로또를_구매할수_있는지_확인() {
        assertThatThrownBy(() -> LottoBuyer.checkCanBuyLotto(10000, 11))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매할 수 있는 로또의 최대 개수를 초과하였습니다.");
    }

    @Test
    public void 구매_가능한_로또_개수_계산() {
        assertThat(LottoBuyer.calculateAutoLottoCount(10000, 3)).isEqualTo(7);
    }

    @Test
    public void 로또_수동_구매() {
        assertThat(lottoBuyer.buyManualLotto(new ArrayList<>(List.of(1, 5, 20, 35, 41, 22))))
                .isEqualTo(lottoBuyer.getBoughtLottos().get(0).getNumbers());
    }

    @Test
    public void 로또_자동_구매() {
        assertThat(lottoBuyer.buyAutoLotto())
                .isEqualTo(lottoBuyer.getBoughtLottos().get(0).getNumbers());
    }

    @Test
    public void 로또_결과_확인() {
        LottoBuyer lottoBuyer1 = new LottoBuyer();
        lottoBuyer1.buyManualLotto(new ArrayList<>(List.of(1, 3, 5, 7, 9, 11)));
        lottoBuyer1.buyManualLotto(new ArrayList<>(List.of(2, 4, 6, 8, 10, 12)));

        Map<Integer, WinningInfo> winningStatics = lottoBuyer1.checkLottoResult("1, 2, 3, 4, 5, 6", 7);

        assertThat(winningStatics.get(1).getWinningCount()).isEqualTo(0);
        assertThat(winningStatics.get(2).getWinningCount()).isEqualTo(0);
        assertThat(winningStatics.get(3).getWinningCount()).isEqualTo(0);
        assertThat(winningStatics.get(4).getWinningCount()).isEqualTo(0);
        assertThat(winningStatics.get(5).getWinningCount()).isEqualTo(2);
        assertThat(winningStatics.get(0).getWinningCount()).isEqualTo(0);
    }

    @Test
    public void 총수익률_계산() {
        LottoBuyer lottoBuyer1 = new LottoBuyer();
        lottoBuyer1.buyManualLotto(new ArrayList<>(List.of(1, 3, 5, 7, 9, 11)));
        lottoBuyer1.buyManualLotto(new ArrayList<>(List.of(2, 4, 6, 8, 10, 12)));

        lottoBuyer1.checkLottoResult("1, 2, 3, 4, 5, 6", 7);

        assertThat(lottoBuyer1.checkReturnRate(10000)).isEqualTo(1.0f);
    }

}