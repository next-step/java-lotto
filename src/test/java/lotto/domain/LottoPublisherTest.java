package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @DisplayName("복권들을 발행할 수 있다.")
    @Test
    void publish() {
        LottoPublisher lottoPublisher = new LottoPublisher();

        Lotteries actual = lottoPublisher.publish(2);

        assertThat(actual).isNotNull();
        assertThat(actual.count()).isEqualTo(2);
    }
}