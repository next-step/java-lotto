package step4.domain;

import org.junit.jupiter.api.Test;
import step4.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {

    @Test
    public void duplicateNumberTest() {
        assertThatThrownBy(() -> {
            LottoFactory.makeLottoWithString("1,1,1,1,1,1");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
