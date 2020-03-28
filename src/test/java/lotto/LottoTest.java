package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;
    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(14);
    }

    @DisplayName("1~45 사이의 숫자 로또번호를 생성한다.")
    @Test
    void generateRandomNumbers() {
        List<Integer> numbers = lotto.generateRandomNumbers();
        assertThat(numbers).hasSize(6);
    }

    @DisplayName("넣은 로또넘버가 같은객체 인지 확인해본다.")
    @Test
    void createLottoNumber() {
        lottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumber).isEqualTo(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
