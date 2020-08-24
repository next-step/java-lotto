package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 생성기")
public class LottoFactoryTest {

    @DisplayName("로또 생성")
    @Test
    public void create() {
        assertThat(LottoFactory.create(14)).hasSize(14);
    }

}
