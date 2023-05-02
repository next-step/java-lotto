package step2.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoIssuanceTest {

    @Test
    void 로또번호_6자리가_생성된다() {
        final var lotto = LottoIssuance.issue();
        final var lottoNumbers = lotto.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }
}
