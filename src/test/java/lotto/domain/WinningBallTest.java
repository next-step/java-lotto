package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningBallTest {

  private LottoBalls winLottoBalls;
  private WinningBall winningBall;

  @BeforeEach
  void setUp() {
    winLottoBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(5), new LottoBall(6)
        )
    );
    winningBall = new WinningBall(winLottoBalls, new LottoBall(45));
  }

  @DisplayName("공이 세개 일치하는 경우 4등이다")
  @Test
  void ball_match_three() {
    LottoBalls drawBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(7), new LottoBall(8), new LottoBall(9)
        )
    );
    Ranking ranking = winningBall.calculateRank(drawBalls);
    assertThat(ranking).isEqualTo(Ranking.FOURTH);
  }

  @DisplayName("공이 네개 일치하는 경우 3등이다")
  @Test
  void ball_match_four() {
    LottoBalls drawBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(8), new LottoBall(9)
        )
    );
    Ranking ranking = winningBall.calculateRank(drawBalls);
    assertThat(ranking).isEqualTo(Ranking.THIRD);
  }

  @DisplayName("공이 다섯개 일치하고 보너스 번호가 없으면 2등이다")
  @Test
  void ball_match_five() {
    LottoBalls drawBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(5), new LottoBall(10)
        )
    );
    Ranking ranking = winningBall.calculateRank(drawBalls);
    assertThat(ranking).isEqualTo(Ranking.SECOND);
  }

  @DisplayName("공이 다섯개 일치하고 보너스 번호도 일치하면 경우 2등 보너스다")
  @Test
  void ball_match_five_bonus() {
    LottoBalls drawBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(5), new LottoBall(45)
        )
    );
    Ranking ranking = winningBall.calculateRank(drawBalls);
    assertThat(ranking).isEqualTo(Ranking.SECOND_BONUS);
  }

  @DisplayName("공이 여섯개 일치하는 경우 1등이다")
  @Test
  void ball_match_six() {
    LottoBalls drawBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(5), new LottoBall(6)
        )
    );
    Ranking ranking = winningBall.calculateRank(drawBalls);
    assertThat(ranking).isEqualTo(Ranking.FIRST);
  }

}