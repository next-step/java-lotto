package net.chandol.lotto.endpoint;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoNumber;
import net.chandol.lotto.util.ConsoleUiUtil;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static net.chandol.lotto.domain.LottoNumber.direct;
import static net.chandol.lotto.util.ConsoleUiUtil.getLottoNumber;
import static net.chandol.lotto.util.ConsoleUiUtil.getLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleUiUtilTest {

    @Test
    public void 로또번호_포메팅() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        String formattedStr = ConsoleUiUtil.formatLotto(lotto);

        assertThat(formattedStr).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 문자열에서_로또번호_추출() {
        String rawLottoNumber = "1,2,3,4,5,6";
        LottoNumber lottoNumber = getLottoNumber(rawLottoNumber);

        assertThat(lottoNumber.getLottoNumbers())
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 문자열리스트에서_로또번호_추출() {
        List<String> rawLottoNumbers = asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        List<LottoNumber> lottoNumbers = getLottoNumbers(rawLottoNumbers);

        assertThat(lottoNumbers)
                .contains(direct(1,2,3,4,5,6))
                .contains(direct(2,3,4,5,6,7));
    }
}