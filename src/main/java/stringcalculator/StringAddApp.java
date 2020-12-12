package stringcalculator;

import stringcalculator.domain.Adder;
import stringcalculator.domain.InputConvertor;

import java.util.List;
import java.util.Scanner;

public class StringAddApp {
    public static void main(String[] args) {
        System.out.print("수식을 입력하세요. (예 1,2:3) >> ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> integers = InputConvertor.convert(input);
        int result = Adder.add(integers);

        System.out.println(String.format("결과는 %d 입니다.", result));
    }
}
