package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또는 6개의 번호가 있다")
    public void lottoHas6NumbersTest() {
        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }


    @Test
    @DisplayName("번호 3개 일치")
    public void matchLottoNumber3Test() {

        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        LottoResult sut = lotto.match(new Numbers(List.of(1, 22, 3, 2, 13, 14)));

        assertThat(sut.getMatchedCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("번호 4개 일치")
    public void matchLottoNumber4Test() {

        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        LottoResult sut = lotto.match(new Numbers(List.of(1, 22, 3, 2, 6, 11)));

        assertThat(sut.getMatchedCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("번호 5개 일치")
    public void matchLottoNumber5Test() {

        Numbers numbers = new Numbers(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        LottoResult sut = lotto.match(new Numbers(List.of(1, 22, 3, 2, 6, 4)));

        assertThat(sut.getMatchedCount()).isEqualTo(5);
    }


}