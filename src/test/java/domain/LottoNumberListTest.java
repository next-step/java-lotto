package domain;

import org.junit.jupiter.api.Test;

public class LottoNumberListTest {
    @Test
    void test() {
        LottoNumbers lottoNumberList = new LottoNumbers();
        lottoNumberList.getNumbers().forEach(it -> System.out.println(it.getLottoNumber()));
    }
}
