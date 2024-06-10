package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("로또는 구입 금액이 있다")
    @Test
    void lottoPrice() {
        assertThat(Lotto.PRICE).isEqualTo(1000);
    }

    @DisplayName("구매 로또는 6개의 당첨 번호로 구성되어 있다")
    @Test
    void lottoNumbers(){
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("구매 로또의 당첨 번호가 6개가 아니면 예외를 발생한다")
    @Test
    void notSixNumber(){
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(numbers));
    }

    @DisplayName("당첨 로또와 3개 숫자가 일치")
    @Test
    void threeMatched(){
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 10, 11, 12), 13);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.FIFTH);
    }

    @DisplayName("당첨 로또와 4개 숫자가 일치")
    @Test
    void fourMatched(){
        Lotto lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Set.of(1, 2, 3, 4, 11, 12), 13);
        assertThat(lotto.match(winningLotto)).isEqualTo(LottoRank.FOURTH);
    }
}