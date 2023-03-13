package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoConsoleView {

    private final Scanner scanner;

    public LottoConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputLottoPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextLine().replace(" ", "");
    }

    public void buyResult(int lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottos));
    }

    public String inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine().replace(" ", "");
    }

    public String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextLine().replace(" ", "");
    }


    public void showLottoNumber(List<Integer> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {
        LottoConsoleView view = new LottoConsoleView();

        view.showLottoNumber(Arrays.asList(1, 2, 3));
    }

}
