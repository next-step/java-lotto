package lotto.domain.sales;

import lotto.domain.number.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBundleTest {

    @Test
    void 수동입력_자동번호생성_로또_생성() {
        List<String> manuals = List.of("1,2,3,4,5,6", "4,5,6,7,8,9");
        LottoBundle lottoBundle = LottoBundle.of(5, manuals);

        assertThat(lottoBundle.lottos().size()).isEqualTo(5 + manuals.size());
        assertThat(lottoBundle.lottos())
                .contains(new Lotto("1,2,3,4,5,6"), new Lotto("4,5,6,7,8,9"));
    }
}
