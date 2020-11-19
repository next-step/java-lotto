package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new TesterLottoGenerator();
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void of() {
        List<Lotto> lottos = Arrays.asList(Lotto.of(lottoGenerator), Lotto.of(lottoGenerator));

        assertThat(new Lottos(lottos))
                .isEqualToComparingFieldByField(new Lottos(lottos));
    }
}