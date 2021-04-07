package lotto.domain;

public class AutoNumberOfTicket {
    private final ManualNumberOfTicket manualNumberOfTicket;
    private final TotalNumberOfTicket totalNumberOfTicket;

    public AutoNumberOfTicket(ManualNumberOfTicket manualNumberOfTicket, TotalNumberOfTicket totalNumberOfTicket) {
        this.manualNumberOfTicket = manualNumberOfTicket;
        this.totalNumberOfTicket = totalNumberOfTicket;
    }

    public int numberOfTicket() {
        return totalNumberOfTicket.minus(manualNumberOfTicket);
    }
}
