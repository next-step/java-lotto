package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class LottoTest {

    @Test
    void testConstructor() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number > Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }

    @Test
    void testNumbers() {
        Lotto lotto = new Lotto();

        Assertions.assertThat(lotto.numbers())
                .hasSize(Lotto.LOTTO_NUMBER)
                .allMatch(number -> number > Lotto.START && number <= Lotto.END)
                .doesNotHaveDuplicates()
                .isSorted();
    }
}
