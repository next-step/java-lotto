package lotto.Model;

public class ManualCount {
    private final int manualCount;

    public ManualCount(String inputNumber, int countOfTicket) {
        manualCount = Integer.parseInt(inputNumber);
        if (manualCount > countOfTicket) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 전체 로또 수보다 작아야 합니다.");
        }
    }

    public int value() {
        return manualCount;
    }
}
