package lotto.dto;

public class LottoMoneyDto {

    private final long cost;
    private final long numberOfAllLottos;

    public LottoMoneyDto(long cost, long numberOfAllLottos) {
        this.cost = cost;
        this.numberOfAllLottos = numberOfAllLottos;
    }

    public long getCost() {
        return cost;
    }

    public long getNumberOfAllLottos() {
        return numberOfAllLottos;
    }
}
