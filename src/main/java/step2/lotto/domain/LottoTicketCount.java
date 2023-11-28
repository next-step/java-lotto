package step2.lotto.domain;

public class LottoTicketCount {

    private final int manualLottoTicketCount;
    private final int randomLottoTicketCount;

    public LottoTicketCount(final int totalLottoTicketCount, final int inputCountOfManualLotto) {
        validateInputManualLotto(totalLottoTicketCount, inputCountOfManualLotto);
        this.manualLottoTicketCount = inputCountOfManualLotto;
        this.randomLottoTicketCount = totalLottoTicketCount - inputCountOfManualLotto;
    }

    private void validateInputManualLotto(final int totalLottoTicketCount, final int countOfManualLotto) {
        if (totalLottoTicketCount < countOfManualLotto) {
            throw new IllegalArgumentException("구입한 금액 보다 더 큰 수동 로또는 입력이 불가능 합니다.");
        }
    }

    public int getRandomLottoTicketCount() {
        return randomLottoTicketCount;
    }

    public int getManualLottoTicketCount() {
        return manualLottoTicketCount;
    }

    public int getTotalLottoTicketCount() {
        return manualLottoTicketCount + randomLottoTicketCount;
    }
}
