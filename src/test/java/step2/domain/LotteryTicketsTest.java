package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.list;

class TestingPlayslip extends Playslip {
    public static Playslip from(int manualSelection, List<LotteryNumber> selectedNumbers) {
        return new TestingPlayslip(manualSelection, selectedNumbers);
    }

    private final int manualSelection;
    private final List<LotteryNumber> selectedNumbers;

    public TestingPlayslip(int manualSelection, List<LotteryNumber> selectedNumbers) {
        this.manualSelection = manualSelection;
        this.selectedNumbers = selectedNumbers;
    }

    @Override
    public List<LotteryNumber> selectNumbers(int numberSet) {
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
        List<LotteryNumber> lotteryNumbers = copy(LotteryNumber.of(1, 2, 3, 4, 5, 6), 3);
        Playslip playslip = TestingPlayslip.from(MANUAL_SELECTION, lotteryNumbers);

        LotteryTickets lotteryTickets = LotteryTickets.of(playslip.selectNumbers(NUMBER_SET), MANUAL_SELECTION);
        assertThat(lotteryTickets).isEqualTo(new LotteryTickets(MANUAL_SELECTION, NATURAL_SELECTION, lotteryNumbers));
    }

    private List<LotteryNumber> copy(LotteryNumber lotteryNumber, int copies) {
        LotteryNumber[] lotteryNumbers = new LotteryNumber[copies];
        for (int i = 0; i < copies; i++) {
            lotteryNumbers[i] = lotteryNumber.copy();
        }
        return list(lotteryNumbers);
    }
}
