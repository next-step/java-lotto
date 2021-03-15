package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    LottoNumbers lottoNumbers;

    @Test
    @DisplayName("섞인번호는 값이 다르다" +
            "로또번호는 6개")
    void shuffle() {
        List<Integer> lottoNumbers1 = lottoNumbers.getLottoNumbers();
        List<Integer> lottoNumbers2 = lottoNumbers.getLottoNumbers();

        assertThat(lottoNumbers1.size()).isEqualTo(6);
        assertThat(lottoNumbers2.size()).isEqualTo(6);
        assertThat(lottoNumbers1).isNotEqualTo(lottoNumbers2);
    }

    @Test
    @DisplayName("로또 1장의 가격은 1000원이다.\n" +
            "14000원을 건네면 14개")
    void price() {
        assertThat(lottoNumbers.howManyPass(14000)).isEqualTo(14); //Q: 잔돈이나, 금액 부족한거는 어쩌지? 요구사항에 없으니 일단 pass
    }

    @BeforeEach
    void init() {
        lottoNumbers = new LottoNumbers();
    }
}