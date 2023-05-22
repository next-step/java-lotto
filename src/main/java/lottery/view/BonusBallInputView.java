package lottery.view;

import lottery.domain.BonusBall;
import lottery.domain.Lottery;
import lottery.domain.LotteryNumber;

import java.util.Scanner;

public class BonusBallInputView implements InputView<BonusBall> {
    Scanner scanner = new Scanner(System.in);
    @Override
    public BonusBall receive() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusBall(new LotteryNumber(scanner.nextInt()));
    }
}
