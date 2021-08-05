package lottery.view;

import lottery.dto.LotteryDto;
import lottery.dto.LotteryNumberDto;

import java.util.List;
import java.util.stream.Collectors;

public class LotteriesConsoleOutput {

    private static final String PURCHASE_COUNT = "개를 구매했습니다.\n";

    public void printLotteries(final List<LotteryDto> lotteryDtos) {
        System.out.println(getLotteriesAsString(lotteryDtos));
    }

    private String getLotteriesAsString(final List<LotteryDto> lotteryDtos) {
        return lotteryDtos.stream()
                .map(this::getLotteryNumbersAsString)
                .collect(Collectors.joining("\n", lotteryDtos.size() + PURCHASE_COUNT, "\n"));
    }

    private String getLotteryNumbersAsString(final LotteryDto lotteryDto) {
        return lotteryDto.getLotteryNumberDtos()
                .stream()
                .map(LotteryNumberDto::getLotteryNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
