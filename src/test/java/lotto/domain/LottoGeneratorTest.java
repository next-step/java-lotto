package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 1. 돈을 받으면 로또를 반환한다.
 */
public class LottoGeneratorTest {
    @DisplayName("3000원을 입력하면 3개의 Lotto 반환 성공 테스트")
    @Test
    void create() {
        List<Lotto> lottos = LottoGenerator.generate(3000);
        assertThat(lottos.size()).isEqualTo(3);
    }

}
