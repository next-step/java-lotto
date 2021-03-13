package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto();
    }

    @DisplayName("1~45번 숫자를 생성한다.")
    @Test
    void createNumber() {
        List<Integer> numbers = lotto.createNumber();

        assertThat(numbers.size()).isEqualTo(45);
    }

    @DisplayName("6번째 번호까지 잘라 로또를 생성한다.")
    @Test
    void createLotto() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> lottoNumbers = lotto.pickNumber(numbers);

        assertThat(lottoNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("1등일 경우 테스트")
    @Test
    void match_1등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        Rank match = lotto.match(winNumber);

        assertThat(match).isEqualTo(Rank.FIRST);
    }

    @DisplayName("2등일 경우 테스트")
    @Test
    void match_2등() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        Rank match = lotto.match(winNumber);

        assertThat(match).isEqualTo(Rank.SECOND);
    }

    @DisplayName("하나도 당청안됬을 경우 테스트")
    @Test
    void match_미스() {
        Lotto lotto = new Lotto(List.of(11, 23, 42, 32, 11, 7));
        List<Integer> winNumber = List.of(1, 2, 3, 4, 5, 6);

        Rank match = lotto.match(winNumber);

        assertThat(match).isEqualTo(Rank.MISS);
    }

}