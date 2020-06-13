package lotto;

import lotto.model.LottoSinglePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    public void testIsLottoWinner() {
        LottoSinglePage page = new LottoSinglePage(new int[]{1, 2, 3, 4, 5, 6});

        assertThat(page.LottoCompare(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(6);
    }

    @Test
    public void testLottoFailed() {
        LottoSinglePage page = new LottoSinglePage(new int[]{2, 5, 7, 13, 16, 19});

        assertThat(page.LottoCompare(new int[]{1, 3, 4, 6, 8, 9})).isEqualTo(0);
    }

    @Test
    public void testLottoGenerator() {
        // TODO : how to check lotto page has 6 numbers?
        LottoSinglePage page = new LottoSinglePage();

        assertThat(page.LottoCompare(new int[]{1, 2, 3, 4, 5, 6})
                + page.LottoCompare(new int[]{7, 8, 9, 10, 11, 12})
                + page.LottoCompare(new int[]{13, 14, 15, 16, 17, 18})
                + page.LottoCompare(new int[]{19, 20, 21, 22, 23, 24})
                + page.LottoCompare(new int[]{25, 26, 27, 28, 29, 30})
                + page.LottoCompare(new int[]{31, 32, 33, 34, 35, 36})
                + page.LottoCompare(new int[]{37, 38, 39, 40, 41, 42})
                + page.LottoCompare(new int[]{43, 44, 45, 46, 47, 48})).isEqualTo(6);
    }

    @Test
    public void testLottoCountError() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoSinglePage(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void testWinnerCount() {
        LottoSinglePage page = new LottoSinglePage(new int[]{2, 5, 7, 13, 16, 19});

        assertThat(page.LottoCompare(new int[]{2, 3, 7, 13, 21, 34})).isEqualTo(3);
    }
}
