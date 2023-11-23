package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void 자동_번호_생성_확인() {
        Lotto lotto = new Lotto();
        int size = lotto.size();

        assertThat(size).isEqualTo(6);
    }

    @Test
    void 갯수_예외() {
        List<LottoNo> sizeLess = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5));
        List<LottoNo> sizeMore = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6), new LottoNo(7));

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sizeLess));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(sizeMore));
    }

    @Test
    void 중복_예외() {
        List<LottoNo> duplicated = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(4));

        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicated));
    }
}
