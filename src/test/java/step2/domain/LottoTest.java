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

        List<Integer> numbers = lotto.createNumbers();

        assertThat(numbers.size()).isEqualTo(45);
    }

    @DisplayName("6번째 번호까지 잘라 로또를 생성한다.")
    @Test
    void createLotto() {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Lotto lotto = this.lotto.createLotto(numbers);

        assertThat(lotto.toNumberList()).contain(1, 2, 3, 4, 5, 6);
    }

}