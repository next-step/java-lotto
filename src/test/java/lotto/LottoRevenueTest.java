package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRevenueCheck;
import lotto.model.LottoWinCheck;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRevenueTest {

    private String winningNumber;
    private List<Lotto> lottos;

    private LottoWinCheck lottoWinCheck;

    private LottoRevenueCheck revenueCheck;

    @BeforeEach
    void setUp() {
        winningNumber = "23,8,11,20,3,45";
        lottos = new ArrayList<>();
        lottos.add(new Lotto("23,18,11,20,43,15"));
        lottos.add(new Lotto("3,5,20,45,11,43"));
        lottos.add(new Lotto("11,2,4,5,8,45"));
        lottos.add(new Lotto("23,21,14,5,8,11"));

        lottoWinCheck = new LottoWinCheck(winningNumber, lottos);
        revenueCheck = new LottoRevenueCheck(lottoWinCheck.getWinLottos());

    }
    @Test
    @DisplayName("당첨 수익률 테스트")
    void winlottoRevenue() {
        float result = revenueCheck.getRevenueRatio("4000");

        assertThat(result).isEqualTo((float) 65000/4000);
    }
}
