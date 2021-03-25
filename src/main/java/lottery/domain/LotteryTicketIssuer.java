package lottery.domain;

import lottery.dto.LotteryNumbersDto;
import lottery.dto.LotteryTicketOrderDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lottery.domain.LotteryNumbers.LOTTERY_SIZE;

public class LotteryTicketIssuer {

    private static final List<Integer> NUMBER_LIST
        = IntStream.rangeClosed(LotteryNumber.MINIMUM_VALUE, LotteryNumber.MAXIMUM_VALUE)
                   .boxed()
                   .collect(Collectors.toList());
    
    static final int LOTTERY_PRICE = 1000;

    private LotteryTicketIssuer() {}

    public static LotteryTicket issue(LotteryTicketOrderDto order) {
        validateOrder(order);

        List<LotteryNumbersDto> lotteryNumbers = order.getLotteryNumbersDtoList();
        int manualAmount = lotteryNumbers.size();
        int automaticAmount = getTotalQuantity(order.getMoney()) - manualAmount;

        List<LotteryNumbers> manualLotteryNumbers = getManualLotteryNumbers(order.getLotteryNumbersDtoList());
        List<LotteryNumbers> automaticLotteryNumbers = getAutomaticLotteryNumbers(automaticAmount);

        return Stream.concat(manualLotteryNumbers.stream(), automaticLotteryNumbers.stream())
                     .collect(Collectors.collectingAndThen(Collectors.toList(), LotteryTicket::new));
    }

    private static void validateOrder(LotteryTicketOrderDto order) {
        int manualLotteryQuantity = order.getLotteryNumbersDtoList().size();
        int totalQuantity = getTotalQuantity(order.getMoney());

        if (totalQuantity < manualLotteryQuantity) {
            throw new ManualLotteryQuantityExceedException();
        }
    }

    private static int getTotalQuantity(int money) {
        return money / LOTTERY_PRICE;
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
