package domain.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @DisplayName("로또 게임 생성 성공 (14000원 입금 -> 14라인 생성)")
    @Test
    void create_lotto_game_success() {
        LottoGame lottoGame = LottoGame.from(14000);
        assertThat(lottoGame.getGameCount()).isEqualTo(14);
        assertThat(lottoGame.getLottoLines()).hasSize(14);
    }

    @DisplayName("로또 게임 생성 성공 (14000원 입금 -> 14라인 생성, 1라인 수동)")
    @Test
    void create_lotto_game_with_manual_lines_success() {
        LottoLine lottoLine = LottoLine.create(Set.of(
                        1, 2, 3, 4, 5, 6)
                .stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet()));

        LottoGame lottoGame = LottoGame.newInstance(14000, 1, List.of(lottoLine));

        assertThat(lottoGame.getGameCount()).isEqualTo(14);
        assertThat(lottoGame.getLottoLines()).hasSize(14);
    }

    @DisplayName("로또 게임 생성 실패 (1000원 입금 ->  2라인 수동)")
    @Test
    void create_lotto_game_with_manual_lines_fail() {
        List<LottoLine> manualLottoLines = List.of(
                LottoLine.create(Set.of(
                                1, 2, 3, 4, 5, 6)
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet())),
                LottoLine.create(Set.of(
                                1, 2, 3, 4, 5, 6)
                        .stream()
                        .map(LottoNumber::from)
                        .collect(Collectors.toSet()))
        );

        assertThatThrownBy(() -> LottoGame.newInstance(1000, 2, manualLottoLines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매 수는 전체 수보다 클 수 없습니다.");
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
