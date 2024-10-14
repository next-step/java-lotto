package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {
    @Test
    void isContains() {
        LottoNo lottoNo = new LottoNo(1);
        boolean isContains = lottoNo.isContains(Set.of(new LottoNo(1), new LottoNo(2)));
        assertThat(isContains).isTrue();
    }
}
