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

    @Test
    @DisplayName("로또 1장의 가격은 1000원이다.\n" +
            "14000원을 건네면 14개")
    void price() {
        assertThat(lotto.howManyPass(14000)).isEqualTo(14); //Q: 잔돈이나, 금액 부족한거는 어쩌지? 요구사항에 없으니 일단 pass
    }

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }
}