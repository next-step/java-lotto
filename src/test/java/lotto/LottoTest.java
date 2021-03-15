package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    Lotto lotto;

    @Test
    @DisplayName("섞인번호는 값이 다르다")
    void shuffle() {
        List<Integer> lottoNumbers1 = lotto.getLottoNumbers();
        List<Integer> lottoNumbers2 = lotto.getLottoNumbers();

        assertThat(lottoNumbers1).isNotEqualTo(lottoNumbers2);
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}