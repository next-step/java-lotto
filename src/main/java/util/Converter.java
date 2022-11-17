package util;

import domain.lottery.LotteryNumber;
import domain.lottery.LotteryTicket;

import java.util.ArrayList;

public class Converter {
    public static LotteryTicket convertStringToLotteryTicket(String[] numbers) {

        LotteryTicket lotteryTicket = LotteryTicket.of(new ArrayList<>());
        for (String number : numbers) {
            lotteryTicket.add(LotteryNumber.of(Integer.parseInt(number)));
        }

        return lotteryTicket;
    }
}
