package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    private static final int AMOUNT = 14_000;
    private static final int PRICE = 1_000;
    private static final int LOTTO_COUNT = AMOUNT / PRICE;
    private LottoGame lottoGame;
    private Price price;

    @Before
    public void setUp() {
        price = new Price(AMOUNT);
        lottoGame = new LottoGame(LOTTO_COUNT);
    }

    @Test
    public void 입력된_STRING_ARRAY_INT_ARRAY로_CONVERTING() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        int[] intWinningNumbers = {1,2,3,4,5,6};
        assertThat(lottoGame.convertingWinningNumbers(winningNumbers)).isEqualTo(intWinningNumbers);
    }

    @Test
    public void 금액에_맞는_LOTTO_갯수가_생성_되었는가() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        assertThat(lottoGame.playingLotto(winningNumbers, price).getLottos().size()).isEqualTo(LOTTO_COUNT);
    }
}
