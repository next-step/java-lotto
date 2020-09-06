package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumTest {

    @Test
    void canMatch() {
        LottoNum buzzNum = new LottoNum(3);
        Lotto otherLotto = new Lotto();

        assertThat(buzzNum.countMatch(otherLotto)).isLessThanOrEqualTo(1);
    }

    @Test
    void canMatchForTest() {
        LottoNum buzzNum = new LottoNum(3);
        List<LottoNum> otherLottoNumList = Arrays.asList(new LottoNum(45), new LottoNum(7), new LottoNum(3),
                                            new LottoNum(4), new LottoNum(17), new LottoNum(31));

        assertThat(buzzNum.countMatchForTest(otherLottoNumList)).isEqualTo(1);
    }
}