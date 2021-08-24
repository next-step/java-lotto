import domain.AutoNumberStrategy;
import domain.LottoNumber;
import domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class LottoNumbersTest {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @Test
    public void 자동으로_6개숫자생성_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers(new AutoNumberStrategy());
        assertThat(lottoNumbers.getValues().size()).isEqualTo(LOTTO_NUMBER_SIZE);
    }

    @Test
    public void 서로다른_6개숫자생성_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers(new AutoNumberStrategy());
        assertThat(new HashSet<>(lottoNumbers.getValues()).size()).isEqualTo(lottoNumbers.getValues().size());
    }

    @Test
    public void 여섯개이상숫자_에러_테스트() {
        assertThatThrownBy(() -> new LottoNumbers(() -> {
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            lottoNumbers.add(new LottoNumber(1));
            lottoNumbers.add(new LottoNumber(2));
            lottoNumbers.add(new LottoNumber(3));
            lottoNumbers.add(new LottoNumber(4));
            lottoNumbers.add(new LottoNumber(5));
            lottoNumbers.add(new LottoNumber(6));
            lottoNumbers.add(new LottoNumber(7));
            return lottoNumbers;
        })).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void 로또범위벗어난숫자_에러_테스트() {
        assertThatThrownBy(() -> new LottoNumbers(() -> {
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            lottoNumbers.add(new LottoNumber(47));
            lottoNumbers.add(new LottoNumber(-1));
            lottoNumbers.add(new LottoNumber(1));
            lottoNumbers.add(new LottoNumber(2));
            lottoNumbers.add(new LottoNumber(3));
            lottoNumbers.add(new LottoNumber(4));
            return lottoNumbers;
        })).isInstanceOf(IllegalArgumentException.class);
    }
}
