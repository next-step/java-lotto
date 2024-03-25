package lotto.domain;

public class ManualLottoCount {
    private final int value;

    public ManualLottoCount(String input, Amount amount) {
        this.value = toManualLottoCount(input, amount);
    }

    public int value() {
        return value;
    }

    private static int toManualLottoCount(String input, Amount amount) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }

        int manualLottoCount;
        try {
            manualLottoCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("0 이상의 정수만 입력할 수 있습니다.");
        }

        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("0 이상의 정수만 입력할 수 있습니다.");
        }

        if (manualLottoCount > amount.lottoTicketCount()) {
            throw new IllegalArgumentException("수동 로또의 수는 총 구매할 로또의 수보다 작거나 같아야 합니다.");
        }

        return manualLottoCount;
    }
}
