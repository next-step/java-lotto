package app.view;

import app.action.LottoMarket;
import app.domain.lotto.Lotteries;
import app.domain.lotto.Lotto;
import app.domain.lotto.LottoNum;
import app.domain.Money;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NEGATIVE_SYMBOL = "-";

    public static Money inputMoney() {
        Money result = null;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                result = inputNumber();
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                String errorMsg = e.getMessage();
                if (errorMsg.contains(NEGATIVE_SYMBOL)) {
                    System.out.println("잘못된 금액입니다. 다시 입력해 주세요.");
                } else {
                    System.out.println("로또 1장이상(" + LottoMarket.PRICE + "원)의 금액을 입력해야 합니다.");
                }
            }
        }
        return result;
    }

    @NotNull
    private static Money inputNumber() {
        Money number = Money.of(Integer.valueOf(scanner.nextLine()));
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

    public static Money inputManual(Lotteries lotteries, Money money) {
        int count = 0;
        int manualMoney = 0;
        while(true){
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            count = Integer.valueOf(scanner.nextLine());
            manualMoney = count * LottoMarket.PRICE;
            if(money.getMoney() > manualMoney){
                break;
            }
            System.out.printf("구입할수 있는 최대 갯수는 %d개 입니다.\n",money.getMoney()/LottoMarket.PRICE);
        }

        for(int i=0; i<count; i++){

        }
        return Money.of(money.getMoney()-manualMoney);
    }
}
