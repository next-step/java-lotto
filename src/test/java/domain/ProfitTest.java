package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    private Profit profit;

    @Before
    public void initProfile() {
        LottoNumbers thirdLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 12));
        LottoNumbers fifthLotto = LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 7, 9, 12));
        List<Lotto> lottos = Arrays.asList(new Lotto(thirdLotto), new Lotto(fifthLotto));
        WinningNumbers winningNumbers = new WinningNumbers(LottoNumbers.convertToLottoNo(Arrays.asList(1, 2, 3, 4, 5, 6)), 8);
        profit = new Profit(new LottoResult(lottos, winningNumbers));
    }

    @Test
    public void 로또_10장구매() {
        assertThat(this.profit.calcProfile(10)).isEqualTo(150.5);
    }
}