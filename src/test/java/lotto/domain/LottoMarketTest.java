package lotto.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
    @Test
    public void 로또생성() {
        List<Integer> numbers = LottoMarket.createNumbers();
        assertThat(numbers).hasSize(6);
    }
}