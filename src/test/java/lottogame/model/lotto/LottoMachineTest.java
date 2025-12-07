package lottogame.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 사용자의_요청값만큼_자동_수동로또를_발행할_수_있다() {
        Lottos lotto = LottoMachine.createTotallyLottos(5, List.of("1, 2, 3, 4, 5, 6"));

        assertThat(
                lotto.size()
        ).isEqualTo(6);
    }

    @Test
    void SET으로_요청받은_갯수만큼_로또번호목록을_생성할_수_있다() {
        assertThat(
                LottoMachine.createLottoNums(Set.of(1, 2, 3, 4, 5, 6)).size()
        ).isEqualTo(6);
    }

    @Test
    void SET으로_요청받은_갯수가_0이하면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> LottoMachine.createLottoNums(Set.of())
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열로_요청받은_갯수만큼_로또번호목록을_생성할_수_있다() {
        assertThat(
                LottoMachine.createLottoNums("1, 2, 3, 4, 5, 6")
        ).contains(
                LottoNum.of(1),
                LottoNum.of(2),
                LottoNum.of(3),
                LottoNum.of(4),
                LottoNum.of(5),
                LottoNum.of(6)
        );
    }

    @Test
    void 문자열로_요청받은_갯수가_ENPTY라면_예외처리_할_수_있다() {
        assertThatThrownBy(
                () -> LottoMachine.createLottoNums("").size()
        ).isInstanceOf(IllegalArgumentException.class);
    }
}