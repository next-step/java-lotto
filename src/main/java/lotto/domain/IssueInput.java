package lotto.domain;

public class IssueInput {

    private final TicketCount autoTicketCount;
    private final int[][] manualLottoNumbers;

    public IssueInput(TicketCount autoTicketCount, int[][] manualLottoNumbers) {
        this.autoTicketCount = autoTicketCount;
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public IssueInput(TicketCount autoTicketCount) {
        this(autoTicketCount, null);
    }

    public IssueInput(int[][] manualLottoNumbers) {
        this(null, manualLottoNumbers);
    }

    public TicketCount getAutoTicketCount() {
        return autoTicketCount;
    }

    public int[][] getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
