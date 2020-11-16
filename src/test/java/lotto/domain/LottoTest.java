package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @DisplayName("당첨 발표전이라면 당첨 결과를 알 수 없음")
    @Test
    void getLottoRank() {
        Lotto lotto = Lotto.of(lottoGenerator);
        assertThatIllegalArgumentException().isThrownBy(lotto::getLottoRank);
    }
}
