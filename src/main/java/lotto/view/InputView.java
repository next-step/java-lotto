package lotto.view;

import lotto.action.LottoMarket;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        int result = 0;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                result = inputNumber();
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                String errorMsg = e.getMessage();
                if (errorMsg.contains("-")) {
                    System.out.println("잘못된 금액입니다. 다시 입력해 주세요 - 입력금액: " + e.getMessage());
                } else {
                    System.out.println("로또 1장이상(" + LottoMarket.PRICE + "원)의 금액을 입력해야 합니다.- 입력금액: " + e.getMessage());
                }
            }
        }
        return result;
    }

    @NotNull
    private static Integer inputNumber() {
        int number = Integer.valueOf(scanner.nextLine());
        if (number < LottoMarket.PRICE) {
            throw new IllegalArgumentException("" + number);
        }
        return number;
    }

    public static Lotto inputWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] numbers = scanner.nextLine().split(",");
        return Lotto.from(convertStrToNum(numbers));
    }

    public static List<Integer> convertStrToNum(String[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.valueOf(number));
        }
        return result;
    }

    public static LottoNum inputBonus() {
        LottoNum result = null;
        while(true){
            System.out.println("보너스 볼을 입력해 주세요.");
            try {
                result = LottoNum.of(scanner.nextLine());
                break;
            }catch (IllegalArgumentException e){
                System.out.println(String.format("%d ~ %d 숫자만 입력할 수 있습니다.",LottoNum.MINIMUM,LottoNum.MAXIMUM));
            }
        }
        return result;
    }
}
