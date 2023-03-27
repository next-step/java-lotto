package lotto.view;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int DEFAULT_PRICE = 1000;

    public int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(scanner.nextLine());
        return money/DEFAULT_PRICE;
    }

    public int inputManualCnt(int gameCount) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");

        int manualCount = Integer.parseInt(scanner.nextLine());

        if(manualCount > gameCount) {
            throw new IllegalArgumentException("구매할 수 있는 범위를 넘었습니다.");
        }
        return manualCount;
    }

    public List<LottoTicket> inputManualNums(int manualCount) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> manualLotto = new ArrayList();

        for (int i = 0; i < manualCount; i++) {
            List<Integer> tickets = new ArrayList<>();
            String inputValue = scanner.nextLine();
            String[] splitValue = inputValue.split(",");
            tickets.clear();

            Arrays.stream(splitValue).mapToInt(Integer::parseInt).forEach(tickets::add);
            manualLotto.add(new LottoTicket(tickets));
        }

        return manualLotto;
    }

    public List<Integer> inputWinningNum() {

        List<Integer> winningNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        Arrays.stream(splitValue).mapToInt(Integer::parseInt).forEach(value -> winningNumbers.add(value));

        return winningNumbers;
    }

    public int inputBonusNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = Integer.parseInt(scanner.nextLine());

        return bonusNum;
    }
}