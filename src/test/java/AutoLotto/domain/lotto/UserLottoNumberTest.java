package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserLottoNumberTest {

    @Test
    void canMatch() {
        LottoNumber buzzNum = new LottoNumber(3);
        UserLotto otherUserLotto = new UserLotto();

        assertThat(buzzNum.countMatch(otherUserLotto)).isLessThanOrEqualTo(1);
    }

    @Test
    void canMatchForTest() {
        LottoNumber buzzNum = new LottoNumber(3);
        List<LottoNumber> otherLottoNumberList = Arrays.asList(new LottoNumber(45), new LottoNumber(7), new LottoNumber(3),
                                            new LottoNumber(4), new LottoNumber(17), new LottoNumber(31));

        assertThat(buzzNum.countMatchForTest(otherLottoNumberList)).isEqualTo(1);
    }
}