package step2.domain;

import java.util.List;

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
