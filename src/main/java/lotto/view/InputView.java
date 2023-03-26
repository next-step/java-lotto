package lotto.view;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    int purchasePrice;
    public int gameCount;
    int manualCount;
    int autoCount;

    List<LottoTicket> manualLotto;

    public void excuteInput(){
        inputMoney();
        inputManualCnt();
        inputManualNums(manualCount);
    }

    public int getAutoCount(){
        return autoCount;
    }

    public int getManualCount(){
        return manualCount;
    }

    public int getPurchasePrice(){
        return purchasePrice;
    }

    public List<LottoTicket> getManualLotto(){
        return manualLotto;
    }

    public void inputMoney() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(scanner.nextLine());
        this.gameCount = money/1000;

        this.purchasePrice =  gameCount * 1000;
    }

    public void inputManualCnt() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");

        int manualCount = Integer.parseInt(scanner.nextLine());

        if(manualCount > gameCount) {
            throw new IllegalArgumentException("구매할 수 있는 범위를 넘었습니다.");
        }

        this.manualCount = manualCount;
        this.autoCount = gameCount - manualCount;
    }

    public void inputManualNums(int manualCount) {

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

        this.manualLotto = manualLotto;
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