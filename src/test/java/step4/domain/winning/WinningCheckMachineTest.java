package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.winning.WinningLotto;
import step4.domain.winning.WinningResult;
import step4.domain.lotto.Lotto;
import step4.domain.rank.Rank;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningCheckMachineTest {

    @DisplayName("WinningCheckMachine 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();

        // then
        assertThat(winningCheckMachine).isNotNull();
    }


    @DisplayName("WinningCheckMachine 인스턴스가 WinningResult 를 반환하는지 테스트")
    @Test
    void 반환() {
        // given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Lotto.of("1, 2, 3, 4, 5, 6"));
        WinningLotto winningLotto = WinningLotto.from("4, 5, 6, 7, 8, 9", 10);

        // when
        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();
        WinningResult winningResult = winningCheckMachine.checkUserLottoAndWinningLotto(lottos, winningLotto);

        assertAll(
                () -> assertThat(winningResult).isNotNull(),
                () -> assertThat(winningResult.getWinningCount(Rank.FIFTH)).isEqualTo(1)
        );

    }



}