package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    public void setUp() {
        lottoNumbers = new LottoNumbers();
    }

    @Test
    @DisplayName("로또 구매 갯수 설정 테스트")
    void purchaseCount() {
        // given
        int money = 14000;

        // when

    }
}
