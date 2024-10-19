package lotto;

import lotto.service.LottoSeller;
import lotto.service.LottoService;
import lotto.service.LottoWinningStaticsCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    public void 구매가능한_로또개수() {
        assertThat(lottoService.canBuyLottoCount(14400))
                .isEqualTo(14);
    }

    @Test
    public void 로또구매() {
        List<Integer> lotto = LottoSeller.sellLotto();

        for (int count = 0; count <= 6; count++) {
            lotto.forEach(number -> {
                assertThat(number).isGreaterThanOrEqualTo(1);
                assertThat(number).isLessThanOrEqualTo(45);
            });
        }
    }

    @Test
    public void 당첨통계() {
        List<Integer>[] lottos = new ArrayList[2];

        lottos[0] = new ArrayList<>(List.of(2, 5, 9, 10, 23, 31));
        lottos[1] = new ArrayList<>(List.of(6, 13, 26, 41, 18, 42));


        List<Integer> winningNumbers = new ArrayList<>(List.of(2, 5, 9, 33, 35, 44));
        assertThat(LottoWinningStaticsCalculator.calculateWinningStatics(winningNumbers, lottos)).isEqualTo(new int[]{1, 0, 0, 1, 0, 0, 0});
    }

    @Test
    public void 총수익률() {
        assertThat(lottoService.provideReturnRate(10000, new int[]{0, 0, 0, 2, 0, 0, 0})).isEqualTo(1.0f);
    }

}
