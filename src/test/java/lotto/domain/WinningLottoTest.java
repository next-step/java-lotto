package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호가 보너스 번호 포함 테스트")
    void containBonusLottoTest() {
        Lotto winning = Lotto.createManualLotto(List.of("1", "2", "3", "4", "5", "6"));
        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("1");

        assertThatThrownBy(() -> WinningLotto.init(winning, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 당첨번호에 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호에 보너스 번호가 없을때 테스트")
    void noContainBonusLottoTest() {
        Lotto winning = Lotto.createManualLotto(List.of("1", "2", "3", "4", "5", "6"));
        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("7");

        WinningLotto winningLotto = WinningLotto.init(winning, bonusNumber);

        assertThat(winningLotto)
                .isInstanceOf(WinningLotto.class);
    }

    @Test
    @DisplayName("로또 매칭 테스트")
    void matchLottoTest() {
        List<String> manualNumbers = List.of("1", "2", "3", "4", "5", "6");
        Lotto winning = Lotto.createManualLotto(manualNumbers);

        Lotto lotto_1 = Lotto.createManualLotto(manualNumbers);
        Lotto lotto_2 = Lotto.createManualLotto(List.of("1", "2", "3", "4", "5", "7"));
        Lotto lotto_3 = Lotto.createManualLotto(List.of("1", "2", "3", "4", "5", "8"));
        Lotto lotto_4 = Lotto.createManualLotto(List.of("1", "2", "3", "4", "9", "8"));
        Lotto lotto_5 = Lotto.createManualLotto(List.of("1", "2", "3", "10", "9", "8"));

        LottoNumber bonusNumber = LottoNumber.createManualLottoNumber("7");

        WinningLotto winningLotto = WinningLotto.init(winning, bonusNumber);

        assertAll(
                () -> assertThat(winningLotto.matchingLotto(lotto_1))
                        .isEqualTo(Statistics.FIRST),

                () -> assertThat(winningLotto.matchingLotto(lotto_2))
                        .isEqualTo(Statistics.SECOND),

                () -> assertThat(winningLotto.matchingLotto(lotto_3))
                        .isEqualTo(Statistics.THIRD),

                () -> assertThat(winningLotto.matchingLotto(lotto_4))
                        .isEqualTo(Statistics.FOURTH),

                () -> assertThat(winningLotto.matchingLotto(lotto_5))
                        .isEqualTo(Statistics.FIFTH)
        );
    }

}
