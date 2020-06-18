package lotto;

import lotto.model.LottoLine;
import lotto.model.LottoNo;
import lotto.model.LottoResult;
import lotto.model.PrizeEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    static LottoLine sampleLine;
    @BeforeAll
    public static void setup() {
        sampleLine = new LottoLine(2, 5, 7, 13, 16, 19);
    }
    @Test
    public void testIsLottoWinner() {
        LottoLine game = new LottoLine(1, 2, 3, 4, 5, 6);

        assertThat(game.getLineContent()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        LottoResult result = new LottoResult(new LottoLine(1, 2, 3, 4, 5, 6), 7);
        assertThat(result.lineResult(game)).isEqualTo(PrizeEnum.SIX);
    }

    @Test
    public void testLottoFailed() {
        LottoResult result = new LottoResult(new LottoLine(1, 3, 4, 6, 8, 9), 2);
        assertThat(result.lineResult(sampleLine)).isEqualTo(PrizeEnum.FAIL);
    }

    @Test
    public void testLottoGenerator() {
        LottoLine line = new LottoLine();
        assertThat(line.getLineContent().split(",").length).isEqualTo(6);
    }

    @Test
    public void testLottoCountError() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoLine(new int[]{1, 2, 3, 4, 5, 6, 7}));
    }

    @Test
    public void testWinnerCount() {
        LottoResult result = new LottoResult(new LottoLine(2, 3, 7, 13, 21, 34), 1);
        assertThat(result.lineResult(sampleLine)).isEqualTo(PrizeEnum.THREE);
    }

    @Test
    public void testBonusWinnerCount() {
        LottoResult result = new LottoResult(new LottoLine(3, 5, 7, 13, 16, 19), 2);
        assertThat(result.lineResult(sampleLine)).isEqualTo(PrizeEnum.FIVE_BONUS);
    }

    @Test
    public void testLottoNumberClass() {
        LottoNo no = new LottoNo(4);
        assertThat(no.toString()).isEqualTo("4");
        assertThat(no.equals(new LottoNo(9))).isEqualTo(false);
    }
}
