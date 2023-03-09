package domain;

import org.junit.jupiter.api.Test;

public class LottoNumberListTest {
    @Test
    void test() {
        LottoNumberList lottoNumberList = new LottoNumberList();
        lottoNumberList.getLottoNumberList().forEach(it -> System.out.println(it.getLottoNumber()));
    }
}
