package util;

import domain.lottery.LotteryTicket;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static LotteryTicket convertStringToLotteryTicket(String[] numbers) {
        List<Integer> lotteryTicketNumbers = new ArrayList<>();
        for (String number : numbers) {
            lotteryTicketNumbers.add(Integer.parseInt(number));
        }

        return new LotteryTicket(lotteryTicketNumbers);
    }
}
