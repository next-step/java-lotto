package step4.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    private LottoNumber LottoNumberTest;

    @Test
    void 중복체크() {
        List<Integer> list = testList(5);
        list.add(1);

        assertThatThrownBy(() ->
                LottoNumberTest = new LottoNumber(list)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또갯수체크(){
        List<Integer> list = testList(5);

        assertThatThrownBy(() ->
                LottoNumberTest = new LottoNumber(list)
        ).isInstanceOf(RuntimeException.class);
    }



    private List<Integer> testList(int listSize) {
        List<Integer> returnList = new ArrayList<>();

        for (int i = 1; i <= listSize; i++) {
            returnList.add(i);
        }

        return returnList;
    }
}


