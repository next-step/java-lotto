package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.lotto.LottoRank;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @Test
    void sumMoney() {
        // Given
        Map<LottoRank, Integer> givenResultLotto = new EnumMap<>(LottoRank.class);
        givenResultLotto.put(LottoRank.THREE_MATCH, 1);
        givenResultLotto.put(LottoRank.FOUR_MATCH, 1);

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