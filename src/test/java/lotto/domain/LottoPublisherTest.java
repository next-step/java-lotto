package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @DisplayName("복권을 자동 발행할 수 있다.")
    @Test
    void publish() {
        LottoPublisher lottoPublisher = new LottoAutoPublisher(2);

        Lotteries actual = lottoPublisher.publish();

        assertThat(actual).isNotNull();
        assertThat(actual.count()).isEqualTo(2);
    }
}