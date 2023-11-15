package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    @DisplayName("[LottoGenerator.generateRandomLotto] 5개 생성 요청시 -> 5개 생성")
    public void generateTest() {
        assertThat(LottoGenerator.generateRandomLotto(5))
                .hasSize(5);
    }
}
