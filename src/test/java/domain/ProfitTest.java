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
        LottoNumbers thirdLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(12)));
        LottoNumbers fifthLotto = new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(7), new LottoNo(9), new LottoNo(12)));
        List<Lotto> lottos = Arrays.asList(new Lotto(thirdLotto), new Lotto(fifthLotto));
        WinningNumbers winningNumbers = new WinningNumbers(new LottoNumbers(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6))), new LottoNo(8));
        profit = new Profit(new LottoResult(lottos, winningNumbers));
    }

    @Test
    public void 로또_10장구매() {
        assertThat(this.profit.calcProfile(10)).isEqualTo(150.5);
    }
}