package lotto.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManualNumberGenerateStrategy implements NumberGenerateStrategy{

    @Override
    public List<Integer> generateNumbers() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");

        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
