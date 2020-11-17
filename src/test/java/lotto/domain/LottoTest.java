package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Lotto 생성 테스트")
    @Test
    void of() {
        assertThat(Lotto.of(lottoGenerator))
                .isEqualToComparingFieldByField(Lotto.of(lottoGenerator));
    }
}
