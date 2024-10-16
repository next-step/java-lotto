package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    void isContains() {
        LottoNo lottoNo = LottoNo.of(1);
        boolean isContains = Set.of(LottoNo.of(1), LottoNo.of(2)).contains(lottoNo);
        assertThat(isContains).isTrue();
    }
}
