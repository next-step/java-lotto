package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;
    @BeforeEach
    public void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("lotto 번호 생성 테스트")
    @Test
    public void getLottoNumber() {
        lotto.makeLottoNumber();
        List result = lotto.getLottoNumber();
        assertThat(result.size()).isEqualTo(6);
    }
}
