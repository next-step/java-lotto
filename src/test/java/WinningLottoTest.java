import domain.Lotto;
import domain.LottoNumber;
import domain.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class WinningLottoTest {

    @Test
    public void 보너스번호_중복에러_테스트() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        assertThatThrownBy(() -> new WinningLotto(new Lotto(() -> lottoNumbers), new LottoNumber(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
