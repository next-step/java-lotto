package lotto.core.omr;

import lotto.core.SixBall;
import lotto.core.round.Rank;
import lotto.core.round.Round;
import lotto.core.round.WinSixBall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OmrTest {
    private static final int WIN_NUM1 = 1;
    private static final int WIN_NUM2 = 2;
    private static final int WIN_NUM3 = 3;
    private static final int WIN_NUM4 = 4;
    private static final int WIN_NUM5 = 5;
    private static final int WIN_NUM6 = 6;
    private static final int WIN_BONUS = 7;

    private static Round round;

    @BeforeAll
    public static void mySixBall() {
        round = new Round(WinSixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, WIN_NUM4, WIN_NUM5, WIN_NUM6), WIN_BONUS);
    }

    @Test
    @DisplayName("꽝 확인")
    public void missTest() {
        assertThat(new Omr(SixBall.valueOf(11, 12, 13, 14, 15, 16)).grade(round))
                .isEqualTo(Rank.MISS);

        assertThat(new Omr(SixBall.valueOf(WIN_NUM1, 12, 13, 14, 15, 16)).grade(round))
                .isEqualTo(Rank.MISS);

        assertThat(new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, 13, 14, 15, 16)).grade(round))
                .isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("5등 확인")
    public void fifthTest() {
        Omr omr = new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, 14, 15, 16));
        Rank rank = omr.grade(round);

        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("4등 확인")
    public void fourthTest() {
        Omr omr = new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, WIN_NUM4, 15, 16));
        Rank rank = omr.grade(round);

        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3등 확인")
    public void thirdTest() {
        Omr omr = new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, WIN_NUM4, WIN_NUM5, 16));
        Rank rank = omr.grade(round);

        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("2등 확인")
    public void secondTest() {
        Omr omr = new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, WIN_NUM4, WIN_NUM5, WIN_BONUS));
        Rank rank = omr.grade(round);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("1등 확인")
    public void firstTest() {
        Omr omr = new Omr(SixBall.valueOf(WIN_NUM1, WIN_NUM2, WIN_NUM3, WIN_NUM4, WIN_NUM5, WIN_NUM6));
        Rank rank = omr.grade(round);

        assertThat(rank).isEqualTo(Rank.FIRST);
    }

}