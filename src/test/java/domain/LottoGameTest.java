package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private static final int AMOUNT = 14_000;
    private static final int PRICE = 1_000;
    private static final int LOTTO_COUNT = AMOUNT / PRICE;
    private static final String[] WINNING_NUMBERS = new String[]{"1","2","3","4","5","6"};
    private static final int BONUS_NUMBER = 7;
    private LottoGame lottoGame;
    private Money money;

    @Before
    public void setUp() {
        money = new Money(AMOUNT);
        lottoGame = new LottoGame(LOTTO_COUNT);
    }

    @Test
    public void 금액에_맞는_LOTTO_갯수가_생성_되었는가() {
        assertThat(lottoGame.playingLotto(new WinningLotto(LottoGameTest.WINNING_NUMBERS, BONUS_NUMBER)).getLottos().size()).isEqualTo(LOTTO_COUNT);
    }
}
