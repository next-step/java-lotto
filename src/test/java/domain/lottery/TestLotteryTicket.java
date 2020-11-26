package domain.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TestLotteryTicket {
    LotteryTicket lotteryTicketBase;
    List<LotteryNumber> lotteryNumbers;
    @BeforeEach
    void setUp() {
        lotteryTicketBase = new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        ));
        lotteryNumbers = new ArrayList<>(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        ));
    }

    @Test
    @DisplayName("로또 넘버 입력받아서 로또 티켓을 생성합니다.")
    void createLotteryTicket() {
        assertThat(lotteryTicketBase).isEqualTo(new LotteryTicket(Arrays.asList(
                new LotteryNumber(1),
                new LotteryNumber(2),
                new LotteryNumber(3),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        )));
    }

    @Test
    @DisplayName("숫자를 입력받아 로또 티켓을 생성합니다.")
    void createWithLotteryNumbers() {
        LotteryTicket lotteryTicket = new LotteryTicket(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(lotteryTicket).isEqualTo(new LotteryTicket(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    @DisplayName("로또 넘버 입력받아서 정렬해서 로또 티켓을 생성합니다.")
    void createSortedLotteryTicket() {
        LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(
                new LotteryNumber(3),
                new LotteryNumber(2),
                new LotteryNumber(1),
                new LotteryNumber(4),
                new LotteryNumber(5),
                new LotteryNumber(6)
        ));
        assertThat(lotteryTicket.getLotteryNumbers()).containsSequence(lotteryNumbers);
    }

    @Test
    @DisplayName("생성된 로또 번호를 정렬하는지 확인한다.")
    void createSortedLotteryNumbers() {
        LotteryTicket lotteryTicket = new LotteryTicket(new int[]{5, 1, 4, 3, 2, 6});
        assertThat(lotteryTicket.getLotteryNumbers()).containsSequence(lotteryNumbers);
    }

    @Test
    @DisplayName("6개 숫자가 아닌 경우")
    void invalidLottoNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(
                   new LotteryNumber(1),
                   new LotteryNumber(2),
                   new LotteryNumber(3),
                   new LotteryNumber(4),
                   new LotteryNumber(5)
           ));
        });
    }

    @Test
    @DisplayName("중복값 체크")
    void invalidLottoNumberDuplication() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           LotteryTicket lotteryTicket = new LotteryTicket(Arrays.asList(
              new LotteryNumber(1),
              new LotteryNumber(2),
              new LotteryNumber(3),
              new LotteryNumber(4),
              new LotteryNumber(5),
              new LotteryNumber(5)
           ));
        });
    }

    @Test
    void matchOneNumbersWithOneLotteryTicket() {
        assertThat(lotteryTicketBase.matchLotteryTicket("6,8,9,10,11,12"))
                .isEqualTo(1);
    }

    @Test
    void matchSixNumbersWithOneLotteryTicket() {
        assertThat(lotteryTicketBase.matchLotteryTicket("1,2,3,4,5,6"))
                .isEqualTo(6);
    }
}
