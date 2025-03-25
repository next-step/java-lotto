package step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void 결과_매칭() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        Lotto lotto0 = Lotto.of(List.of(11, 12, 13, 14, 15, 16));
        Lotto lotto1 = Lotto.of(List.of(1, 12, 13, 14, 15, 16));
        Lotto lotto2 = Lotto.of(List.of(1, 2, 13, 14, 15, 16));
        Lotto lotto3 = Lotto.of(List.of(1, 2, 3, 14, 15, 16));
        Lotto lotto4 = Lotto.of(List.of(1, 2, 3, 4, 15, 16));
        Lotto lotto5 = Lotto.of(List.of(1, 2, 3, 4, 5, 16));
        Lotto lotto6 = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        assertThat(LottoResult.getResult(lotto0, lotto)).isEqualTo(LottoResult.NONE);
        assertThat(LottoResult.getResult(lotto1, lotto)).isEqualTo(LottoResult.NONE);
        assertThat(LottoResult.getResult(lotto2, lotto)).isEqualTo(LottoResult.NONE);
        assertThat(LottoResult.getResult(lotto3, lotto)).isEqualTo(LottoResult.FOURTH);
        assertThat(LottoResult.getResult(lotto4, lotto)).isEqualTo(LottoResult.THIRD);
        assertThat(LottoResult.getResult(lotto5, lotto)).isEqualTo(LottoResult.SECOND);
        assertThat(LottoResult.getResult(lotto6, lotto)).isEqualTo(LottoResult.FIRST);
    }
}
