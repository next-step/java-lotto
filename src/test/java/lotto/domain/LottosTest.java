package lotto.domain;

import lotto.domain.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottosTest {

    @DisplayName("자동, 수동 구매 가능")
    @Test
    void create_both() {
        String lottoNumber = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(1, Arrays.asList(lottoNumber));

        assertThat(lottos.getLottos()).hasSize(2);
        assertThat(lottos.getLottos()).contains(new Lotto(lottoNumber));
    }

    @DisplayName("불가능한 수동 구매 입력_null")
    @Test
    void create_manual_fail() {
        assertDoesNotThrow(() -> new Lottos(0, new ArrayList<>()));
        assertThatThrownBy(() -> new Lottos(0, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매 넘버는 null일 수 없습니다.");
    }

    @DisplayName("불가능한 자동 구매 입력_음수")
    @Test
    void create_auto_fail() {
        assertDoesNotThrow(() -> new Lottos(0, new ArrayList<>()));
        assertThatThrownBy(() -> new Lottos(-1, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 개수는 0 미만일 수 없습니다.");
    }

    @DisplayName("당첨 번호 체크 로직 위임 확인")
    @Test
    void checkWinning() {
        String lottoNumber = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(0, Arrays.asList(lottoNumber));
        Ranks ranks = lottos.checkWinning(new WinLotto(new Lotto(lottoNumber), LottoNumber.valueOf(7)));

        assertThat(ranks.countRankOf(Rank.FIRST)).isEqualTo(1);
    }

}
