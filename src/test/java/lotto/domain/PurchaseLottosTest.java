package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@SuppressWarnings("NonAsciiCharacters")
class PurchaseLottosTest {

    @ParameterizedTest
    @CsvSource({
            "3, 3",
            "0, 0",
            "2, 2"
    })
    void 구매로또리스트_생성_테스트(int input, int expected){
        PurchaseLottos purchaseLottos = new PurchaseLottos(input);
        int actual = purchaseLottos.getPurchaseLottoList()
                .size();

        assertThat(actual).isEqualTo(expected);
    }

}