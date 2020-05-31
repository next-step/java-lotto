package lottery;

import lottery.domain.LotteryNumber;
import lottery.domain.LotteryRank;
import lottery.domain.LotteryTicket;
import lottery.view.ViewMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LotteryTicketTest {

    private List<LotteryNumber> lotteryNumberList;

    @BeforeEach
    public void resetLotteryNumberList() {
        lotteryNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotteryNumberList.add(LotteryNumber.from(i));
        }
    }

    @DisplayName("LotteryTicket 객체 정상 생성 테스트")
    @Test
    public void makeLotteryTicket() {
        LotteryTicket lotteryTicket = LotteryTicket.from(lotteryNumberList);

        assertThat(lotteryTicket.getLotteryNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("LotteryTicket 자동 생성 모드로 객체 생성 테스트")
    @Test
    public void makeLotteryTicketAutomaticMode() {
        assertThatCode(() -> {
            LotteryTicket.publishAutomaticLotteryTicket();
        }).doesNotThrowAnyException();
    }

    @DisplayName("LotteryTicket 문자열 배열을 받았을 때 객체 생성")
    @Test
    public void makeLotteryTicketFromStringArrays() {
        String[] input = "1, 2, 3, 4, 5, 6".split(ViewMessages.COMMA);
        LotteryTicket lotteryTicket = LotteryTicket.from(input);

        assertThat(lotteryTicket.getLotteryNumbers())
                .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("LotteryTicket 객체 생성 실패(개수 예외)")
    @Test
    public void throwExceptionOnMakingLotteryTicket() {
        lotteryNumberList.remove(0);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryTicket.from(lotteryNumberList);
                });
    }

    @DisplayName("LotteryTicket 객체 생성 실패(중복된 번호)")
    @Test
    public void throwDuplicatedExceptionOnMakingLotteryTicket() {
        lotteryNumberList.remove(0);
        lotteryNumberList.add(LotteryNumber.from(2));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LotteryTicket.from(lotteryNumberList);
                });
    }

    @DisplayName("맞춘 로또 개수에 따라 그에 맞는 LotteryRank 반환")
    @Test
    public void getMatchLotteryRank() {
        LotteryTicket lotteryTicket = LotteryTicket.from(lotteryNumberList);
        LotteryTicket winnerTicket = LotteryTicket.from("1,2,3,4,5,6".split(","));

        assertThat(lotteryTicket.getMatchLotteryRank(winnerTicket))
                .isEqualTo(LotteryRank.FIRST_PRIZE);
    }

    @DisplayName("보너스 볼 포함 여부를 확인해서 2등 3등을 구분해 LotteryRank 반환")
    @Test
    public void getSecondOrThirdLotteryRankOnBonusBall() {
        LotteryTicket secondWinnerTicket = LotteryTicket.from(lotteryNumberList);
        LotteryTicket thirdWinnerTicket = LotteryTicket.from("1,2,3,4,9,44".split(","));

        LotteryTicket winnerTicket = LotteryTicket.from("1,2,3,4,44,45".split(","));
        LotteryNumber bonusBallNumber = LotteryNumber.from(5);

        assertThat(secondWinnerTicket.getMatchLotteryRank(winnerTicket, bonusBallNumber))
                .isEqualTo(LotteryRank.SECOND_PRIZE);
        assertThat(thirdWinnerTicket.getMatchLotteryRank(winnerTicket, bonusBallNumber))
                .isEqualTo(LotteryRank.THIRD_PRIZE);
    }
}
