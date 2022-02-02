package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("로또를_생성하는_기능_테스트_6가지_숫자를_선택")
    @Test
    void lottoGenerateTest() {
        List<Integer> lottoNumber = Arrays.asList(8, 21, 23, 41, 42, 43);
        Lotto lotto = new Lotto(lottoNumber);
        assertThat(lotto).isNotNull();
    }
}
