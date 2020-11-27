package humbledude.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class AccountManagerTest {

    private AccountManager accountManager;
    private LottoWinningNumbers winningNumbers;
    private List<LottoNumbers> tickets;

    @BeforeEach
    public void setUp() {
        accountManager = new AccountManager(14000);
        winningNumbers = new LottoWinningNumbers(
                new LottoNumbers(TestHelper.setOf(1, 2, 3, 4, 5, 6)),
                LottoNumber.of(7));

        // 미리 당첨 안되는거 9개 넣어놓기
        tickets = new ArrayList<>();
        IntStream.range(0, 9)
                .forEach(i -> tickets.add(new LottoNumbers(TestHelper.setOf(11, 12, 13, 14, 15, 16))));
    }

    @Test
    public void profitRate() {
        // 미리 넣어놓은 당첨 안된거 9개 + 5000원 당첨 1개
        tickets.add(new LottoNumbers(TestHelper.setOf(1, 2, 3, 14, 15, 16)));
        accountManager.buyManualLottos(tickets);
        accountManager.setWinningNumbers(winningNumbers);

        assertThat(accountManager.getProfitRate()).isEqualTo(0.5);
    }

    @Test
    public void getMaxAmountOfLottosWithinBudget() {
        assertThat(accountManager.getMaxAmountOfLottosWithinBudget()).isEqualTo(14);
    }

    @Test
    public void outOfRange_exception() {
        IntStream.range(0, 9)
                .forEach(i -> tickets.add(new LottoNumbers(TestHelper.setOf(11, 12, 13, 14, 15, 16))));
        assertThatIllegalArgumentException().isThrownBy(
                () -> accountManager.buyManualLottos(tickets));
    }
}
