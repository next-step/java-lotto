package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("그 주에 해당하는 당첨번호를 뽑는다.")
    public void winningNumber() {
        Lotto lotto = new Lotto(12000);

        List<Integer> lottoNumber = lotto.getLottoNumber();
        Set<Integer> setLottoNumber = Set.copyOf(lottoNumber);

        assertThat(lottoNumber.size()).isEqualTo(6);
        assertThat(setLottoNumber.size()).isEqualTo(6);

    }

    @RepeatedTest(value = 6)
    @DisplayName("사용자가 사용할 로또 숫자를 뽑는다.")
    public void randomLottoNumber(RepetitionInfo repetitionInfo) {
        Lotto lotto = new Lotto(12000);

        List<List<Integer>> lottoList = lotto.chooseLottoNumber(lotto.purchase());
        assertThat(lottoList.size()).isEqualTo(12);
        assertThat(lottoList.get(repetitionInfo.getCurrentRepetition()).size()).isEqualTo(6);

    }

    @Test
    @DisplayName("로또를 구매한다.")
    public void purchase() {
        Lotto lotto = new Lotto(12000);
        assertThat(lotto).isEqualTo(new Lotto(12000));
        assertThat(lotto.purchase()).isEqualTo(12);
    }

}
