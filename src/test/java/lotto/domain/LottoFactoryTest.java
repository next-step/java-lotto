package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    void assertNumberOfPurchasedTicketWithManualTicket() {
        int numberOfTickets = 5;

        List<String[]> manualTicket = new ArrayList<>();
        String[] testData = "1, 2, 3, 4, 5, 6".split(", ");
        manualTicket.add(testData);

        LottoFactory lottoFactory = new LottoFactory(numberOfTickets, manualTicket);
        assertThat(lottoFactory.numberOfPurchasedTicket()).isEqualTo(6);
    }
}