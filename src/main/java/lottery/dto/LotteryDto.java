package lottery.dto;

import java.util.List;

public class LotteryDto {

    private final List<LotteryNumberDto> lotteryNumberDtos;

    public LotteryDto(final List<LotteryNumberDto> lotteryNumberDtos) {
        this.lotteryNumberDtos = lotteryNumberDtos;
    }

    public List<LotteryNumberDto> getLotteryNumberDtos() {
        return lotteryNumberDtos;
    }
}
