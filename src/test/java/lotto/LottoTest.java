package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


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

    @DisplayName("로또 숫자가 같다면 두 로또 객체는 같다")
    @Test
    void testEquals(){
        List<Integer> lottoList = Lotto.creatNumbers();
        Lotto one = new Lotto(lottoList);
        Lotto another = new Lotto(lottoList);

        Assertions.assertThat(one)
                .isEqualTo(another);
    }
}
