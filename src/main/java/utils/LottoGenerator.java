package utils;

import java.util.*;

public class LottoGenerator {
    private static List<Integer> numbers;

    public static List<Integer> generateNumberList(int lottoCount){
        numbers = new ArrayList<>();
        for(int i = 1; i < 46; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers, new Random());
        numbers = numbers.subList(0,lottoCount);
        Collections.sort(numbers);
        return numbers;
    }
}
