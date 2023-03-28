package lotto.view;

import java.util.ArrayList;
import java.util.Scanner;

public class InputView {
    private static final int MAXIMUM_NUMBER = 45;
    private static final int MINIMUM_NUMBER = 1;
    private static final int DEFAULT_DIGIT = 6;
    ArrayList<Integer> winningNumbers = new ArrayList<>();

    public int inputMoney() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(scanner.nextLine());
        int gameCount = (int)Math.floor(money/1000); // 게임당 1000원

        System.out.println( String.format("%d개를 구매했습니다.", gameCount) ); //n개를 구매했습니다.

        return money;
    }

    public ArrayList<Integer> inputWinningNum() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.nextLine();
        String[] splitValue = inputValue.split(",");

        for (int i = 0; i < DEFAULT_DIGIT; i++) {
            int value = Integer.parseInt(splitValue[i]);
            if(value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER)
                throw new IllegalArgumentException("로또번호 : 1 ~ 45");

            if(winningNumbers.contains(value))
                throw new IllegalArgumentException("중복된 번호가 있습니다.");

            winningNumbers.add(value);
        }

        return winningNumbers;
    }

    public int inputBonusNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = Integer.parseInt(scanner.nextLine());

        if(winningNumbers.contains(bonusNum))
            throw new IllegalArgumentException("당첨번호와 중복된 번호입니다.");
        return bonusNum;
    }
}