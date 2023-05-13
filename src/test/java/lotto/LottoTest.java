package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto;

    @BeforeEach
    public void init(){
        lotto = new Lotto();
    }

    @Test
    public void getLottoNumbersTest() {
        var expected = 6;

        lotto.shuffleLottoNumber(new LottoBalls());
        var actualList = lotto.createLotto();

        assertThat(expected).isEqualTo(actualList.size());
    }

    @Test
    public void equalsCountTest(){
        List<Number> list = List.of(Number.createNumber(1), Number.createNumber(2), Number.createNumber(3), Number.createNumber(4), Number.createNumber(5), Number.createNumber(6));
        lotto = Lotto.createLotto(list);

        List<Number> winningNumber = List.of(Number.createNumber(4), Number.createNumber(2), Number.createNumber(3), Number.createNumber(8), Number.createNumber(5), Number.createNumber(12));

        var expectCount = 4;
        var actualCount = lotto.equalsCount(winningNumber);

        assertThat(actualCount).isEqualTo(expectCount);
    }

    @Test
    public void lottoSortTest(){
        List<Number> list = new java.util.ArrayList<>(List.of(Number.createNumber(33), Number.createNumber(22), Number.createNumber(3), Number.createNumber(41), Number.createNumber(5), Number.createNumber(10)));
        Lotto actualLotto = Lotto.createLotto(list);

        actualLotto.sortLotto();
        var actualList = actualLotto.createLotto();

        List<Number> list2 = List.of(Number.createNumber(3), Number.createNumber(5), Number.createNumber(10), Number.createNumber(22), Number.createNumber(33), Number.createNumber(41));
        assertThat(actualList).isEqualTo(list2);
    }

}
