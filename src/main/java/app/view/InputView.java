package app.view;

import app.action.LottoMarket;
import app.domain.ManualCount;
import app.domain.Money;
import app.domain.lotto.Lotteries;
import app.domain.lotto.Lotto;
import app.domain.lotto.LottoNum;
import app.domain.lotto.WinnerLotto;
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

    public static WinnerLotto inputWinnerNumber(LottoNum bonus) {
        WinnerLotto lotto = null;
        while (true) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String[] numbers = scanner.nextLine().split(",");
            try {
                lotto = WinnerLotto.of(Lotto.from(convertStrToNum(numbers)), bonus);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

        return lotto;
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
        ManualCount count = null;
        count = inputManualCount(money);
        int manualMoney = count.getCount() * LottoMarket.PRICE;
        buyLottoManually(lotteries, count);

        return Money.of(money.getMoney() - manualMoney);
    }

    private static ManualCount inputManualCount(Money money) {
        ManualCount count = null;

        while (true) {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            count = ManualCount.of(scanner.nextLine());
            if (money.getMoney() >= count.getCount() * LottoMarket.PRICE) {
                break;
            }
            System.out.printf("구입할수 있는 최대 갯수는 %d개 입니다.\n", money.getMoney() / LottoMarket.PRICE);
        }
        return count;
    }

    private static void buyLottoManually(Lotteries lotteries, ManualCount count) {
        for (int i = 0; i < count.getCount(); i++) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            try {
                lotteries.addManualLotto(Lotto.from(scanner.nextLine()));
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
                i--;
                continue;
            }
        }
    }
}
