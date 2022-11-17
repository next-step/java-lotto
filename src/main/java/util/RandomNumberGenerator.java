package util;

import domain.lottery.LotteryNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static List<LotteryNumber> generateNumbers() {
        List<LotteryNumber> numberCandidates = new ArrayList<>();

        for (int number = 1; number <= 45; number++) {
            numberCandidates.add(LotteryNumber.of(number));
        }

        Collections.shuffle(numberCandidates);

        List<LotteryNumber> ticketNumbers = new ArrayList<>();
        for (int index = 0; index < 6; index++) {
            ticketNumbers.add(numberCandidates.get(index));
        }

        return ticketNumbers;
    }
}