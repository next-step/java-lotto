package lotto;

import lotto.domain.LottoNumberMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMakerTest {

    private static final int LOTTO_NUMBER_SIZE = 6;

    @Test
    @DisplayName("로또 번호 6개가 추출되는지 확인")
    public void make_new_numbers() {
        List<Integer> newNumbers = LottoNumberMaker.makeNewNumbers();
        assertThat(newNumbers.size()).isEqualTo(LOTTO_NUMBER_SIZE);
    }
}
