package lottery.dto;

public class LottoTries {

    private static final String ILLEGAL_POSSIBLE_TRIES = "올바른 이용 횟수가 아닙니다.";

    private final int totalTries;
    private final int manualTries;
    private final int randomTries;

    public LottoTries(int totalTries, int manualTriesInput) {
        this.totalTries = totalTries;
        this.manualTries = checkManualTriesInput(manualTriesInput);
        this.randomTries = this.totalTries - this.manualTries;
    }

    private int checkManualTriesInput(int manualTriesInput) {
        if (manualTriesInput > totalTries || manualTriesInput < 0) {
            throw new IllegalArgumentException(ILLEGAL_POSSIBLE_TRIES);
        }
        return manualTriesInput;
    }

    public int getRandomTries() {
        return randomTries;
    }

    public int getManualTries() {
        return manualTries;
    }
}
