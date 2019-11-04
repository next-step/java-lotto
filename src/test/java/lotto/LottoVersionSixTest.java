package lotto;

import lotto.domain.CreatableLotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoVersionSixTest {
    CreatableLotto creatableLotto;

    @BeforeEach
    void setUp() {
        creatableLotto = new LottoFactory().getLottoVersionSix();
    }

    @Test
    void lottoVersionSixSizeTest() {
        assertThat(creatableLotto.makeLotto()).hasSize(45);
    }
}
