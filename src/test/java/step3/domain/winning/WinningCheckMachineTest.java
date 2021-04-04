package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @DisplayName("WinningCheckMachine 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();

        // then
        assertThat(winningCheckMachine).isNotNull();
    }

    @DisplayName("WinningCheckMachine 인스턴스가 WinningResult 인스턴스 반환 여부 테스트")
    @Test
    void 반환() {
        // when
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of("1, 2, 3, 4, 5, 6"));
        WinningLotto winningLotto = WinningLotto.from("4, 5, 6, 7, 8, 9", 10);

        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();
        WinningResult winningResult = winningCheckMachine.getWinningResult(lottos, winningLotto);

        assertThat(winningResult).isNotNull();
    }

}