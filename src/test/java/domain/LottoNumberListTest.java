package domain;

import org.junit.jupiter.api.Test;

public class LottoNumberListTest {
    @Test
    void test() {
        LottoNumbers lottoNumberList = LottoNumbers.createAutoLottoNumbers();
        lottoNumberList.getNumbers().forEach(it -> System.out.println(it.getNumber()));
    }
}
