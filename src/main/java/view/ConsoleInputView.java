package view;

import domain.NumberSet;
import util.StringParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static Integer inputPrice(){
        System.out.println("구매금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Integer inputManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<NumberSet> inputManualLottoNumbers(Integer count){
        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");

        return IntStream.range(0, count)
            .mapToObj(i -> NumberSet.fill(StringParser.strToIntegerArray(scanner.next())))
            .collect(Collectors.toList());
    }

    public static NumberSet inputWinningNumbers(){
        System.out.println("지난 주 당첨번호를 입력해주세요.");
        return NumberSet.fill(StringParser.strToIntegerArray(scanner.next()));
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");

        return scanner.nextInt();
    }
}
