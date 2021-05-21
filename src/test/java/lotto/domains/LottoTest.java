package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 생성자_테스트() {
        Lotto lotto = new Lotto();
        assertThat(lotto).isNotNull();
    }
}
