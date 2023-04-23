package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.NumberFactory;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    List<Integer> numberList;
    NumberFactory factory;

    @BeforeEach
    void init() {
        numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        factory = new NumberFactory(() -> numberList);
    }

    @Test
    void 구입_금액만큼_구매_번호_리스트가_생성된다() {

        // given
        int price = 14000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        NumberFactory factory = new NumberFactory(() -> numberList);

        // when
        List<List<Integer>> result = factory.createNumber(price);

        // then
        assertThat(result).hasSize(14);
    }

    @Test
    void 구매_번호_리스트는_랜덤으로_생성된다() {

        // given
        int price = 1000;
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        NumberFactory factory = new NumberFactory(() -> numberList);

        // when
        List<List<Integer>> result = factory.createNumber(price);

        // then
        assertThat(result).contains(numberList);
    }
}
