package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RankGroupTest {
    private RankGroup rankGroup;

    @BeforeEach
    public void setup() {
        Set<LotteryNumber> lotteryNumber = new HashSet<>();
        for(int i=1; i<=6; i++){
            lotteryNumber.add(new LotteryNumber(i));
        }

        WinningLottery winningLottery = new WinningLottery(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8)), 0);
        rankGroup = new RankGroup(new LotteryTicket(lotteryNumber), winningLottery);
    }

    @Test
    @DisplayName("당첨 확인(4개당첨 1개 있으므로 4랭크만 1 나머지 0이 나와야 한다.")
    public void rankingCheck() {
        Assertions.assertAll(
                () -> assertThat(rankGroup.count(3, 0)).isEqualTo(0),
                () -> assertThat(rankGroup.count(4, 0)).isEqualTo(1),
                () -> assertThat(rankGroup.count(5, 0)).isEqualTo(0),
                () -> assertThat(rankGroup.count(5, 1)).isEqualTo(0),
                () -> assertThat(rankGroup.count(6, 0)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("보너스 볼 은 한개만 존재한다.")
    public void validBonusBallNumber() {
        Assertions.assertAll(
                () -> assertThat(rankGroup.count(1, 0)).isEqualTo(0),
                () -> assertThat(rankGroup.count(1, 1)).isEqualTo(0)
        );
    }
}
