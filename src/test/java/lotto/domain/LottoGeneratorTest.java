package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("로또를_생성하는_기능_테스트_6가지_숫자를_선택")
    @Test
    void lottoGenerateTest() {
        Lotto lotto = LottoGenerator.generateLotto();
        assertThat(lotto.getLottoNumber()).isNotNull();
    }

}
