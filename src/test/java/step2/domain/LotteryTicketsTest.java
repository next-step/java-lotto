package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.Sets;

import java.util.Set;

class TestingPlayslip extends Playslip {
    public static Playslip from(int manualSelection, int naturalSelection, Set<LotteryNumber> selectedNumbers) {
        return new TestingPlayslip(manualSelection, naturalSelection, selectedNumbers);
    }

    private final int manualSelection;
    private final int naturalSelection;
    private final Set<LotteryNumber> selectedNumbers;

    public TestingPlayslip(int manualSelection, int naturalSelection, Set<LotteryNumber> selectedNumbers) {
        this.manualSelection = manualSelection;
        this.naturalSelection = naturalSelection;
        this.selectedNumbers = selectedNumbers;
    }

    @Override
    public Set<LotteryNumber> selectNumbers(int numberSet) {
        return selectedNumbers;
    }

    @Override
    public int getNaturalSelectionCount() {
        return naturalSelection;
    }

    @Override
    public int getManualSelectionCount() {
        return manualSelection;
    }
}

class LotteryTicketsTest {
    @DisplayName("Playslip 으로부터 LotteryTicket 을 생성한다.")
    @Test
    void fromPlayslip() {
        LotteryNumber lotteryNumber = LotteryNumber.of(1, 2, 3, 4, 5, 6);
        Playslip playslip = TestingPlayslip.from(1, 3, copy(lotteryNumber, 4));

        LotteryTickets lotteryTickets = LotteryTickets.of(playslip);
        Assertions.assertThat(lotteryTickets).isEqualTo(new LotteryTickets(1, 3, copy(lotteryNumber, 4)));
    }

    private Set<LotteryNumber> copy(LotteryNumber lotteryNumber, int copies) {
        LotteryNumber[] lotteryNumbers = new LotteryNumber[copies];
        for (int i = 0; i < copies; i++) {
            lotteryNumbers[i] = lotteryNumber.copy();
        }
        return Sets.of(lotteryNumbers);
    }
}
