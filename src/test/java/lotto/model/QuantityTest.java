package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class QuantityTest {

    private Quantity quantity;

    @BeforeEach
    void setUp() {
        this.quantity = new Quantity(3);
    }

    @Test
    void exists() {
        assertThat(quantity.exists()).isTrue();
    }

    @Test
    void reduce() {
        quantity.reduce();
        assertThat(quantity).isEqualTo(new Quantity(2));
    }
}
