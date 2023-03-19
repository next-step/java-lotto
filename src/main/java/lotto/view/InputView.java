package lotto.view;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private List<LottoTicket> tickets = new ArrayList<>();
    public int inputMoney() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public ArrayList<Integer> inputWinningNum() {
        ArrayList<Integer> winningNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(splitValue[i]));
        }

        return winningNumbers;
    }

    public int inputBonusNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = Integer.parseInt(scanner.nextLine());

        return bonusNum;
    }
}
