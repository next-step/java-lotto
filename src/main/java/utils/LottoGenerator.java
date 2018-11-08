package utils;

import java.util.*;

public class LottoGenerator {
    private static List<Integer> numbers = new ArrayList<>();

    public static List<Integer> generateNumberList(int lottoCount){
        numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26
                ,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45);
        Collections.shuffle(numbers, new Random());

        numbers = numbers.subList(0,lottoCount);
        Collections.sort(numbers);
        return numbers;
    }
}
