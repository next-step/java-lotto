package net.chandol.lotto.endpoint;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.LottoNumberItem;
import net.chandol.lotto.view.ViewUtil;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static net.chandol.lotto.value.LottoNumber.direct;
import static net.chandol.lotto.view.ViewUtil.getLottoNumber;
import static net.chandol.lotto.view.ViewUtil.getLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class ViewUtilTest {

    @Test
    public void 로또번호_포메팅() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        String formattedStr = ViewUtil.formatLotto(lotto);

        assertThat(formattedStr).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 문자열에서_로또번호_추출() {
        String rawLottoNumber = "1,2,3,4,5,6";
        LottoNumber lottoNumber = getLottoNumber(rawLottoNumber);

        assertThat(lottoNumber.getLottoNumbers())
                .containsExactly(new LottoNumberItem(1), new LottoNumberItem(2), new LottoNumberItem(3), new LottoNumberItem(4), new LottoNumberItem(5), new LottoNumberItem(6));
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