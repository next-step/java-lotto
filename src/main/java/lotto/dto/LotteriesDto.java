package lotto.dto;

public class LotteriesDto {
    private int index;
    private String lotteryNumber;

    public LotteriesDto(int index, String lotteryNumber) {
        this.index = index;
        this.lotteryNumber = lotteryNumber;
    }

    public int getIndex() {
        return index;
    }

    public String getLotteryNumber() {
        return lotteryNumber;
    }
}
