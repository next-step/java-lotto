package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.Sets;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TestingPlayslip extends Playslip {
    public static Playslip from(int manualSelection, Set<LotteryNumber> selectedNumbers) {
        return new TestingPlayslip(manualSelection, selectedNumbers);
    }

    private final int manualSelection;
    private final Set<LotteryNumber> selectedNumbers;

    public TestingPlayslip(int manualSelection, Set<LotteryNumber> selectedNumbers) {
        this.manualSelection = manualSelection;
        this.selectedNumbers = selectedNumbers;
    }

    @Override
    public Set<LotteryNumber> selectNumbers(int numberSet) {
        return selectedNumbers;
    }

    @Override
    public int getManualSelectionCount() {
        return manualSelection;
    }
}

class LotteryTicketsTest {

    public static final int MANUAL_SELECTION = 1;
    public static final int NATURAL_SELECTION = 2;
    public static final int NUMBER_SET = 3;

    @DisplayName("Playslip 으로부터 LotteryTicket 을 생성한다.")
    @Test
    void fromPlayslip() {
        Set<LotteryNumber> lotteryNumbers = Sets.of(LotteryNumber.of(1, 2, 3, 4, 5, 6), //
                LotteryNumber.of(11, 12, 13, 14, 15, 16), //
                LotteryNumber.of(21, 22, 23, 24, 25, 26));
        Playslip playslip = TestingPlayslip.from(MANUAL_SELECTION, lotteryNumbers);

        LotteryTickets lotteryTickets = LotteryTickets.of(playslip.selectNumbers(NUMBER_SET), MANUAL_SELECTION);
        assertThat(lotteryTickets).isEqualTo(new LotteryTickets(MANUAL_SELECTION, NATURAL_SELECTION, lotteryNumbers));
    }
}
