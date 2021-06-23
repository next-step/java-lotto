package lotto.dto;

import lotto.core.Machine;
import lotto.core.exception.LottoRuleException;
import lotto.core.round.Round;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또 당첨번호 정보 테스트")
class WinningBallDTOTest {

    WinningBallDTO winningBallDTO;

    @BeforeEach
    public void setup() {
        winningBallDTO = new WinningBallDTO();
    }

    @DisplayName("로또 당첨번호 정보가 정상적인 경우")
    @Test
    public void toRound() {
        //When
        winningBallDTO.setFixedBalls("1, 2, 3, 4, 5, 6");
        winningBallDTO.setBounsBall("7");

        //Then
        Round round = winningBallDTO.toRound();
        assertAll(
            () -> assertThat(round.getSixBall().contains(Machine.draw(1))).isTrue(),
            () -> assertThat(round.getSixBall().contains(Machine.draw(2))).isTrue(),
            () -> assertThat(round.getSixBall().contains(Machine.draw(3))).isTrue(),
            () -> assertThat(round.getSixBall().contains(Machine.draw(4))).isTrue(),
            () -> assertThat(round.getSixBall().contains(Machine.draw(5))).isTrue(),
            () -> assertThat(round.getSixBall().contains(Machine.draw(6))).isTrue(),
            () -> assertThat(round.getBonusBall()).isEqualTo(Machine.draw(7))
        );
    }

    @DisplayName("로또 당첨번호가 숫자가 아닌 경우")
    @Test
    public void toRoundException1() {
        assertThatThrownBy(() -> winningBallDTO.setFixedBalls("1, TEXT"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 가능");
    }

    @DisplayName("로또 보너스 당첨번호가 숫자가 아닌 경우")
    @Test
    public void toRoundException3() {
        assertThatThrownBy(() -> winningBallDTO.setBounsBall("TEXT"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 가능");
    }

    @DisplayName("로또 보너스번호가 당첨번호의 포함된 경우")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void toRoundException4(int bouns) {
        winningBallDTO.setFixedBalls("1, 2, 3, 4, 5, 6");
        winningBallDTO.setBounsBall(String.valueOf(bouns));

        assertThatThrownBy(() -> winningBallDTO.toRound())
                .isInstanceOf(LottoRuleException.class)
                .hasMessageContaining("보너스 볼").hasMessageContaining("당첨 번호에 포함");
    }

    @DisplayName("로또 당첨번호가 6개 이하를 입력하는 경우")
    @Test
    public void toRoundException5() {
        winningBallDTO.setFixedBalls("1, 2, 3, 4");
        winningBallDTO.setBounsBall("45");

        assertThatThrownBy(() -> winningBallDTO.toRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 총").hasMessageContaining("개를 입력");
    }

    @DisplayName("로또 당첨번호가 중복이 포함되는 경우")
    @Test
    public void toRoundException6() {
        winningBallDTO.setFixedBalls("1, 1, 1, 4, 5, 6");
        winningBallDTO.setBounsBall("45");

        assertThatThrownBy(() -> winningBallDTO.toRound())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 총").hasMessageContaining("개를 입력");
    }

}