package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 자동생성 - 번호 자동생성됨")
    void generateAuto() {
        Lotto generated = Lotto.auto();

        List<Integer> numbers = generated.getNumbers();

        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("지난 주 당첨번호와 매칭 테스트")
    void match() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(lottoNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,7));
        Lotto winningLotto = new Lotto(winningNumbers);

        WinningResult winningResult = lotto.match(winningLotto);

        assertThat(winningResult.getResults()).hasSize(1);
        assertThat(winningResult.getResults()).isEqualTo(Arrays.asList(WinningType.SECOND));
    }
}
