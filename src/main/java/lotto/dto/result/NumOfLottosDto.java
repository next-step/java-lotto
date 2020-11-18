package lotto.dto.result;

public class NumOfLottosDto {
    private final int numOfManualLottos;
    private final int numOfAutoLottos;

    public NumOfLottosDto(int numOfManualLottos, int numOfAutoLottos) {
        this.numOfManualLottos = numOfManualLottos;
        this.numOfAutoLottos = numOfAutoLottos;
    }

    public int getNumOfManualLottos() {
        return numOfManualLottos;
    }

    public int getNumOfAutoLottos() {
        return numOfAutoLottos;
    }
}
