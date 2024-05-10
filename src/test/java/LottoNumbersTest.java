import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    public void 로또번호는_6개다() {
        LottoNumbers lottoNumbers = new Lotto().numbers();
        assertThat(lottoNumbers.get().size()).isEqualTo(6);
    }

    @Test
    public void 로또번호는_1부터_45이내다() {
        LottoNumbers lottoNumbers = new Lotto().numbers();

        long inRangeCount = lottoNumbers.get().stream()
                .map(LottoNumber::get)
                .filter(i -> i >= 1 && i <= 45)
                .count();

        assertThat(inRangeCount).isEqualTo(6);
    }

    @Test
    public void 로또번호는_중복이_없다() {
        LottoNumbers lottoNumbers = new Lotto().numbers();

        long uniqueCount = lottoNumbers.get().stream()
                .distinct()
                .count();

        assertThat(uniqueCount).isEqualTo(6);
    }
}
