package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void getLotto() {
        List<Integer> lotto = Lotto.getLotto();
        assertThat(lotto).hasSize(6);
        assertThat(lotto).allMatch(number -> number >= 1 && number <= 45);
        assertThat(lotto).doesNotHaveDuplicates();
    }

    @Test
    void lottoSorted() {
        List<Integer> lotto = Lotto.getLotto();
        assertThat(lotto).isSorted();
    }
}
