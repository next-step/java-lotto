package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    Lotto lotto;

    private static final int LOTTO_PRICE = 1000;

    @BeforeEach
    public void init() {
        lotto = new Lotto();
    }

    @Test
    public void createTest_ValidationCheck(){
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,6,7));

        assertThatThrownBy(() -> Lotto.createLotto(winningList, LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개입니다.");
    }

    @Test
    public void createTest_동일번호체크(){
        List<Number> winningList = Number.createNumberList(List.of(1,2,3,4,5,1));

        assertThatThrownBy(() -> Lotto.createLotto(winningList, LOTTO_PRICE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 중복은 불가능합니다.");
    }

    @Test
    public void getLottoNumbersTest() {
        var expected = 6;
        var actualList = Lotto.createLotto(Number.createNumberList(List.of(1,2,3,4,5,6)), LOTTO_PRICE);

        assertThat(expected).isEqualTo(actualList.getSize());
    }

    @Test
    public void equalsCountTest() {
        List<Number> list = Number.createNumberList(List.of(1,2,3,4,5,6));
        lotto = Lotto.createLotto(list, LOTTO_PRICE);

        List<Number> winningNumber = Number.createNumberList(List.of(4,2,3,8,5,12));;

        var expectCount = 4;
        var actualCount = lotto.equalsCount(winningNumber);

        assertThat(actualCount).isEqualTo(expectCount);
    }

    @Test
    public void lottoSortTest() {
        List<Number> list = new java.util.ArrayList<>(List.of(Number.createNumber(33), Number.createNumber(22), Number.createNumber(3), Number.createNumber(41), Number.createNumber(5), Number.createNumber(10)));

        Lotto actualLotto = Lotto.createLotto(list, LOTTO_PRICE);
        actualLotto.sortLotto();
        var actualList = actualLotto.getLottoNumbers();

        List<Number> list2 = List.of(Number.createNumber(3), Number.createNumber(5), Number.createNumber(10), Number.createNumber(22), Number.createNumber(33), Number.createNumber(41));
        assertThat(actualList).isEqualTo(list2);
    }

}
