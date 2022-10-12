package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoNumberPublisherTest {
    @Test
    void 로또번호를발행한다() {
        int[] lottoNumbers = LottoNumberPublisher.publish();

        Assertions.assertThat(lottoNumbers).hasSize(6);
    }
}
