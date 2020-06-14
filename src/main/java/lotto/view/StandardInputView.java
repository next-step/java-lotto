package lotto.view;

import lotto.model.LottoLine;

import java.util.Arrays;
import java.util.Scanner;

public class StandardInputView implements LottoInput {
    Scanner scanner;

    public StandardInputView() {
        scanner = new Scanner(System.in);
    }

    public int getPurchacePrice() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public LottoLine getWinnerLine() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String line = scanner.nextLine();
        if( line.equals("") )
            line = scanner.nextLine();

        return new LottoLine(Arrays.stream(line.replace(" ", "").
                split(",")).mapToInt(Integer::parseInt).toArray());
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }
}
