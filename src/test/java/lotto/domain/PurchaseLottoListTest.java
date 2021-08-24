package lotto.domain;

import lotto.LottoConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class PurchaseLottoListTest {

    @ParameterizedTest
    @CsvSource({
            "3, 3",
            "0, 0",
            "2, 2"
    })
    void 구매로또리스트_생성_테스트(int input, int expected){
        PurchaseLottoList purchaseLottoList = new PurchaseLottoList(input);
        int actual = purchaseLottoList.getPurchaseLottoList()
                .size();

        assertThat(actual).isEqualTo(expected);
    }

}