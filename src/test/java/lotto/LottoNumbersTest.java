package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    LottoNumbers lottoNumbers1;
    LottoNumbers lottoNumbers2;

    @Test
    @DisplayName("로또 1장의 가격은 1000원이다.\n" +
            "14000원을 건네면 14개")
    void price() {
        assertThat(lottoNumbers1.lottoCount(14000))
                .isEqualTo(14); //Q: 잔돈이나, 금액 부족한거는 어쩌지? 요구사항에 없으니 일단 pass
    }

    @Test
    @DisplayName("숫자가 맞으면 1을 더해준다")
    void contains() {
        assertThat(lottoNumbers1.contains(10, 5)).isEqualTo(6);
    }

    @BeforeEach
    void init() {
        lottoNumbers1 = new LottoNumbers();
        lottoNumbers2 = new LottoNumbers();
    }
}
