package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    @Test
    void sum_multiple_moneys() {
        Prizes prizes = new Prizes(List.of(
                new Money(1000),
                new Money(2000),
                new Money(3000),
                new Money(4000)
        ));

        assertThat(prizes.sum()).isEqualTo(new Money(10000));
    }
}