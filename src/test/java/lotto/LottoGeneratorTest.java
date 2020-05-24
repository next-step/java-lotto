package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성기를 생성하는데 어떤 에러도 발생하지 않는다.")
    void 로또_생성기_생성_테스트() {
        assertThatCode(() -> new LottoGenerator()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또를 자동으로 생성하고 결과크기를 검증한다.")
    void 로또_자동_생성_테스트() {
        LottoGenerator generator = new LottoGenerator();
        Lotto lotto = generator.autoGenerate();
        assertThat(lotto.getLottoNumbers()).hasSize(7);
    }
}
