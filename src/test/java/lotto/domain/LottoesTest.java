package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoesTest {

    @Test
    @DisplayName("주어진 숫자만큼 로또가 생성되는지 테스트")
    public void purchaseCountTest() {

        // given, when
        Lottoes lottoes = new Lottoes(3);

        // then
        assertThat(lottoes.getLottoes().size()).isEqualTo(3);
    }
}
