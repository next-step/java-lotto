package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoFactoryTest {
    @DisplayName("발급된 로또 번호는 1~45 사이의 값 중 6개 이다.")
    @Test
    void publicTicket() {
        Lotto lotto = LottoFactory.auto();
        List<LottoNumber> lottoNumber = lotto.getLottoNumbers();
        assertThat(lottoNumber.size()).isEqualTo(6);
        lottoNumber.forEach(i -> assertThat(i.getNumber()).isBetween(1, 45));
    }

    @Test
    void 수동_티켓_음수면_에러() {
        List<Integer> userManualLottoNumber = List.of(-1, 2, 3, 4, 5, 7);
        assertThatThrownBy(() ->
                LottoFactory.manualLotto(userManualLottoNumber)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 우승 번호에 포함 되지 않았는지 확인한다")
    @Test
    void bonusCheck() {
        assertThatThrownBy(() ->
                LottoFactory.manualWinningLotto(List.of(1,2,3,4,5,6), 6)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 유니크하게 발급되었는지 확인한다")
    @Test
    void uniqueCheck() {
        assertThatThrownBy(() ->
                LottoFactory.manualLotto(List.of(1,2,3,3,4,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
