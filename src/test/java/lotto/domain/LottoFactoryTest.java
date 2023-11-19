package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void assertNumberOfPurchasedTicket() {
        int numberOfTickets = 5;
        Random random = new Random();

        LottoFactory lottoFactory = new LottoFactory(numberOfTickets, random);
        assertThat(lottoFactory.numberOfPurchasedTicket()).isEqualTo(5);
    }
}