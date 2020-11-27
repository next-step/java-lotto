package step4.lotto.domain.numbers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoManualNumberTest {

    private List<String> testList = new ArrayList<>();
    private LottoManualNumber lottoManualNumberTest;

    @Test
    void 구매갯수와_입력한_로또_갯수_테스트() {
        assertThatThrownBy(() ->
                lottoManualNumberTest = new LottoManualNumber(testList, 7)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자_입력_테스트() {
        testList.add("test");
        assertThatThrownBy(() ->
                lottoManualNumberTest = new LottoManualNumber(testList, 6)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또번호_입력_갯수_테스트() {
        testList.add("1,2,3,4,5");
        assertThatThrownBy(() ->
                lottoManualNumberTest = new LottoManualNumber(testList, 6)
        ).isInstanceOf(RuntimeException.class);
    }

    @BeforeEach
    void initData() {
        testList.add("1,2,3,4,5,6");
        testList.add("1,2,3,4,5,6");
        testList.add("1,2,3,4,5,6");
        testList.add("1,2,3,4,5,6");
        testList.add("1,2,3,4,5,6");
        testList.add("1,2,3,4,5,6");
    }


}
