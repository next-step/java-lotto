package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 생성")
    void create() {
        assertThat(LottoNumberFixture.ONE).isNotNull();
    }
}