import domain.AutoNumberStrategy;
import domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

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
}
