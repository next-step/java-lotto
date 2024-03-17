package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultTest {

    @Test
    @DisplayName("addResultCount를 호출하면 매개변수에 따라 3, 4, 5, 6에 해당하는 변수 가산")
    void addResultCount() {
        LottoResult lottoResult = new LottoResult();

        lottoResult.addResultCount(2);

        lottoResult.addResultCount(3);

        lottoResult.addResultCount(4);
        lottoResult.addResultCount(4);

        lottoResult.addResultCount(5);
        lottoResult.addResultCount(5);

        lottoResult.addResultCount(6);

        assertThat(lottoResult.getCountOfThreeCorrectLotto()).isEqualTo(1);
        assertThat(lottoResult.getCountOfFourCorrectLotto()).isEqualTo(2);
        assertThat(lottoResult.getCountOfFiveCorrectLotto()).isEqualTo(2);
        assertThat(lottoResult.getCountOfSixCorrectLotto()).isEqualTo(1);
    }
}
