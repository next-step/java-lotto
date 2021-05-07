package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = new Lotto();
        ResultView resultView = new ResultView();
        WinningNumber winningNumber = new WinningNumber();

        System.out.println("구매 금액을 입력해 주세요");
        int money = inputView.insertPayMoney();
        int lottoCount = lotto.buyLotto(money);

        resultView.createLotto(lottoCount);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = inputView.insertWinningNumber();

        System.out.println("보너스 볼을 입력해 주세요.");
        inputView.insertBonusNumber();

        System.out.println("당첨 통계");
        System.out.println("--------------------------------------------");

        winningNumber.grade(lotto.sortLottoNumber(lotto.createLottoNumber(lotto.shuffleLottoBall())),winningNumbers);
    }

}

class InputView {

    Scanner scanner;

    public int insertPayMoney() {
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<String> splitWinningNumber(String input) {
        List<String> splitInputs = new ArrayList<>(Arrays.asList(input.replaceAll(" ", "").split(",")));
        return splitInputs;
    }

    public List<Integer> insertWinningNumber() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> splitInputs = splitWinningNumber(input);
        List<Integer> winningNumbers = new ArrayList<>();
        for(int i = 0; i < splitInputs.size(); i++){
            winningNumbers.add(Integer.parseInt(splitInputs.get(i)));
        }
        return winningNumbers;
    }


    public String insertBonusNumber() {
        scanner = new Scanner(System.in);
        return scanner.next();
    }

}

class ResultView {
    Lotto lotto = new Lotto();

    public void createLotto(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoCount; i++) {
            System.out.println(lotto.sortLottoNumber(lotto.createLottoNumber(lotto.shuffleLottoBall())));
        }
    }


}