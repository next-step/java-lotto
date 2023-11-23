package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 게임 생성 성공 (14000원 입금 -> 14라인 생성)")
    @Test
    void create_lotto_game_success() {
        LottoGame lottoGame = LottoGame.from(14000);
        assertThat(lottoGame.getGameCount()).isEqualTo(14);
        assertThat(lottoGame.getLottoLines()).hasSize(14);
    }

    @DisplayName("로또 회차 우승번호 등록 성공")
    @Test
    void register_winnging_number_success() {
        Set<Integer> given = Set.of(
                1, 2, 3, 4, 5, 6);

        Set<LottoNumber> winningNumbers = given.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());

        LottoGame lottoGame = LottoGame.from(1000);

        lottoGame.registerWinningLottoLine(new WinnginLottoLine(winningNumbers));

        assertThat(lottoGame.getWinningLottoLine().getLottoNumbers())
                .extracting("number")
                .containsExactlyInAnyOrderElementsOf(given);
    }

    @DisplayName("로또 보너스볼 등록 성공")
    @Test
    void register_bonus_ball_success() {
        LottoGame lottoGame = LottoGame.from(1000);
        lottoGame.registerBonusBall(7);

        assertThat(lottoGame.getBonusBall().getNumber()).isEqualTo(7);
    }
}
