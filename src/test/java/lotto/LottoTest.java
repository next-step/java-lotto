package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또가 6개의 랜덤 숫자를 가지도록 하는 테스트")
    @Test
    public void lottoNumberTest() {
        // 로또가 랜덤 난수로 제대로 만들어졌다면, 6개의 로또 번호를 가지고 있을 것
        Lotto lotto = LottoFactory.createLottoWithRandomNumbers();
        assertThat(lotto.getLottoSize()).isEqualTo(6);
    }

    @DisplayName("로또 생성시 예외사항을 확인하는 테스트")
    @Test
    public void lottoDuplicateNumberExceptionTest() {
        assertThatThrownBy(() ->
                LottoFactory.createLotto(Arrays.asList(1, 1, 3, 30, 40, 44)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                LottoFactory.createLotto(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 입력받아 로또 체크 객체를 생성하는 테스트")
    @Test
    public void createWinnerLottoAndCheckerTest() {
        Lotto winnerLotto = LottoFactory.createLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new LottoChecker(null, winnerLotto)
                .containsWinnerNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isTrue();

        assertThatThrownBy(() ->
                new LottoChecker(null, null))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
