package lottery.view;

import lottery.dto.LotteryDto;
import lottery.dto.LotteryNumberDto;
import lottery.dto.LotteryQuantityDto;

import java.util.List;
import java.util.stream.Collectors;

public class LotteriesConsoleOutput {

    private static final String MANUAL = "\n수동으로 ";
    private static final String AND = "장, 자동으로 ";
    private static final String PURCHASE_COUNT = "개를 구매했습니다.\n";

    public static void printLotteries(final List<LotteryDto> lotteryDtos) {
        System.out.println(getLotteriesAsString(lotteryDtos));
    }

    public static void printLotteries(final LotteryQuantityDto lotteryQuantityDto, final List<LotteryDto> lotteryDtos) {
        System.out.println(getLotteriesAsString(lotteryQuantityDto, lotteryDtos));
    }

    private static String getLotteriesAsString(final List<LotteryDto> lotteryDtos) {
        return lotteryDtos.stream()
                .map(LotteriesConsoleOutput::getLotteryNumbersAsString)
                .collect(Collectors.joining("\n", getPrefix(lotteryDtos), "\n"));
    }

    private static String getLotteriesAsString(final LotteryQuantityDto lotteryQuantityDto, final List<LotteryDto> lotteryDtos) {
        return lotteryDtos.stream()
                .map(LotteriesConsoleOutput::getLotteryNumbersAsString)
                .collect(Collectors.joining("\n", getPrefix(lotteryQuantityDto, lotteryDtos), "\n"));
    }

    private static String getPrefix(final List<LotteryDto> lotteryDtos) {
        return "\n" + lotteryDtos.size() + PURCHASE_COUNT;
    }

    private static String getPrefix(final LotteryQuantityDto lotteryQuantityDto, final List<LotteryDto> lotteryDtos) {
        return MANUAL + lotteryQuantityDto.getQuantity() + AND + lotteryDtos.size() + PURCHASE_COUNT;
    }

    private static String getLotteryNumbersAsString(final LotteryDto lotteryDto) {
        return lotteryDto.getLotteryNumberDtos()
                .stream()
                .map(LotteryNumberDto::getLotteryNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
