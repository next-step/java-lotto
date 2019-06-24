package lotto.model;


import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoAggregatorTest {

    final static int MATCHED_COUNT = 1;

    @Test
    public void aggregate() {
        Aggregate aggregate = new Aggregate();
        aggregate.put(MATCHED_COUNT);
        aggregate.put(MATCHED_COUNT);
        assertThat(aggregate.get(MATCHED_COUNT)).isEqualTo(2);
    }
}
