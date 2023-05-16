package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto;

    @BeforeEach
    public void init() {
        lotto = new Lotto();
    }

    @Test
    public void getLottoNumbersTest() {
        var expected = 6;
        var actualList = Lotto.createLotto(Number.createNumberList(List.of(1,2,3,4,5,6)));

        assertThat(expected).isEqualTo(actualList.getSize());
    }

    @Test
    public void equalsCountTest() {
        List<Number> list = Number.createNumberList(List.of(1,2,3,4,5,6));
        lotto = Lotto.createLotto(list);

        List<Number> winningNumber = Number.createNumberList(List.of(4,2,3,8,5,12));;

        var expectCount = 4;
        var actualCount = lotto.equalsCount(winningNumber);

        assertThat(actualCount).isEqualTo(expectCount);
    }

    @Test
    public void lottoSortTest() {
        List<Number> list = new java.util.ArrayList<>(List.of(Number.createNumber(33), Number.createNumber(22), Number.createNumber(3), Number.createNumber(41), Number.createNumber(5), Number.createNumber(10)));

        Lotto actualLotto = Lotto.createLotto(list);
        actualLotto.sortLotto();
        var actualList = actualLotto.getLottoNumbers();

        List<Number> list2 = List.of(Number.createNumber(3), Number.createNumber(5), Number.createNumber(10), Number.createNumber(22), Number.createNumber(33), Number.createNumber(41));
        assertThat(actualList).isEqualTo(list2);
    }

}
