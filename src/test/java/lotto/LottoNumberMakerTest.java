package lotto;

import lotto.domain.LottoNumberMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMakerTest {

    private static final int LOTTO_NUMBER_BOUND = 45;
    private LottoNumberMaker lottoNumberMaker;

    @Test
    @DisplayName("새로 생성한 로또 번호가 범위 내에 있는지 확인")
    public void make_new_numbers() {
        lottoNumberMaker = new LottoNumberMaker();
        List<Integer> newNumbers = lottoNumberMaker.makeNewNumbers();
        boolean result = newNumbers.stream().allMatch(i -> i <= LOTTO_NUMBER_BOUND);
        assertThat(result).isTrue();
    }
}
