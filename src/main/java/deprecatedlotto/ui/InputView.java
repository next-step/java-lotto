package deprecatedlotto.ui;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static int purchaseAmount(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

   public static List<Integer> lottoWinnerNumbers(Scanner scanner) {
       System.out.println("지난주 당첨 번호를 입력해주세요");
       String winnserNumbers = scanner.nextLine();
       return Stream.of(winnserNumbers.replaceAll("\\s","").split(","))
               .map(Integer::parseInt)
               .collect(Collectors.toList( ));
   }

}
