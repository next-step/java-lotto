package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoPublisherTest {
    private LottoPublisher publisher;

    @BeforeEach
    void setUp() {
        publisher = new LottoPublisher();
    }

    @Test
    void IllegalArgumentException_투입금액유효성검사() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            publisher.validatePurchaseAmount(0);
            publisher.validatePurchaseAmount(-1000);
            publisher.validatePurchaseAmount(11500);
        });
    }
}
