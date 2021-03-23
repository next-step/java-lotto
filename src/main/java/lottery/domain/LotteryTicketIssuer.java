package lottery.domain;

import lottery.dto.LotteryNumbersDto;
import lottery.dto.LotteryTicketOrderDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lottery.domain.LotteryNumber.LOTTERY_NUMBER_MAX;
import static lottery.domain.LotteryNumber.LOTTERY_NUMBER_MIN;
import static lottery.domain.LotteryNumbers.LOTTERY_SIZE;

public class LotteryTicketIssuer {

    private static final List<Integer> NUMBER_LIST = IntStream.rangeClosed(LOTTERY_NUMBER_MIN, LOTTERY_NUMBER_MAX)
                                                              .boxed()
                                                              .collect(Collectors.toList());
    static final int LOTTERY_PRICE = 1000;

    private LotteryTicketIssuer() {}

    public static LotteryTicket issue(LotteryTicketOrderDto lotteryTicketOrderDto) {
        int money = lotteryTicketOrderDto.getMoney();
        List<LotteryNumbersDto> lotteryNumbers = lotteryTicketOrderDto.getmanualLotteryNumbers();
        int manualAmount = lotteryNumbers.size();

        int automaticAmount = (money / LOTTERY_PRICE) - manualAmount;

        List<LotteryNumbers> manualLotteryNumbers = getManualLotteryNumbers(lotteryNumbers);

        List<LotteryNumbers> automaticLotteryNumbers = getAutomaticLotteryNumbers(automaticAmount);

        return Stream.concat(manualLotteryNumbers.stream(), automaticLotteryNumbers.stream())
                     .collect(Collectors.collectingAndThen(Collectors.toList(), LotteryTicket::new));
    }

    private static List<LotteryNumbers> getManualLotteryNumbers(List<LotteryNumbersDto> lotteryNumbersDtoList) {
        return lotteryNumbersDtoList.stream()
                                    .map(dto -> new LotteryNumbers(dto.getNumbers()))
                                    .collect(Collectors.toList());
    }

    private static List<LotteryNumbers> getAutomaticLotteryNumbers(int amount) {
        return Stream.generate(LotteryTicketIssuer::generateLotteryNumbers)
                     .limit(amount)
                     .collect(Collectors.toList());
    }

    public static LotteryTicket issue(int money) {
        return Stream.generate(LotteryTicketIssuer::generateLotteryNumbers)
                     .limit(money / LOTTERY_PRICE)
                     .collect(Collectors.collectingAndThen(Collectors.toList(), LotteryTicket::new));
    }

    private static LotteryNumbers generateLotteryNumbers() {
        List<Integer> numbers = new ArrayList<>(NUMBER_LIST);

        Collections.shuffle(numbers);

        List<Integer> pickedList = numbers.subList(0, LOTTERY_SIZE)
                                          .stream()
                                          .sorted()
                                          .collect(Collectors.toList());

        return new LotteryNumbers(pickedList);
    }

}
