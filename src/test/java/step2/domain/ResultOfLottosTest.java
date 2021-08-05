package step2.domain;

import org.junit.jupiter.api.Test;
import step2.domain.lotto.LottoNumber;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultOfLottosTest {

    @Test
    void sumMoney() {
        // Given
        Map<LottoNumber, Integer> givenResultLotto = new EnumMap<>(LottoNumber.class);
        givenResultLotto.put(LottoNumber._3_NUMBER, 1);
        givenResultLotto.put(LottoNumber._4_NUMBER, 1);

        Integer sum = givenResultLotto.keySet()
            .stream()
            .map(lottoRank -> lottoRank.getWinMoney() * givenResultLotto.get(lottoRank))
            .reduce(Integer::sum).orElse(0);

        // When
        int expectedResoutOfMoney = 55000;

        // Then
        assertThat(sum).isEqualTo(expectedResoutOfMoney);


    }

}