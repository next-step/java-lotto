package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {
    public static final Random random = new Random();

    public static List<Integer> generateNumbers(){
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6) {
            int number = getNumber();
            addNumber(numbers, number);
        }

        return numbers;
    }

    private static void addNumber(List<Integer> numbers, int number) {
        if(!numbers.contains(number)){
            numbers.add(number);
        }
    }

    public static int getNumber(){
        return random.nextInt(45) + 1;
    }
}
