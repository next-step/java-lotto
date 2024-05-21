import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또번호는_6개다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    public void 로또번호는_1부터_45이내다() {
        Lotto lotto = new Lotto();

        long inRangeCount = lotto.get().stream()
                .map(LottoNumber::get)
                .filter(i -> i >= 1 && i <= 45)
                .count();

        assertThat(inRangeCount).isEqualTo(6);
    }

    @Test
    public void 로또번호는_중복이_없다() {
        Lotto lotto = new Lotto();

        long uniqueCount = lotto.get().stream()
                .distinct()
                .count();

        assertThat(uniqueCount).isEqualTo(6);
    }
}
