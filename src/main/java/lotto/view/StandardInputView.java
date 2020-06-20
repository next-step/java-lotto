package lotto.view;

import lotto.model.LottoLine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StandardInputView implements LottoInput {
    Scanner scanner;

    public StandardInputView() {
        scanner = new Scanner(System.in);
    }

    public int getPurchasePrice() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public int getPurchaseManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private LottoLine lineStringToLottoLine(String line) {
        return new LottoLine(Arrays.stream(line.replace(" ", "").
                split(",")).mapToInt(Integer::parseInt).toArray());
    }

    public List<LottoLine> getManualLottoLines() {
        ArrayList<LottoLine> lines = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {
            lines.add(getManualSingleLottoLine());
        }
        return lines;
    }

    private LottoLine getManualSingleLottoLine() {
        String line = scanner.nextLine();
        if (line.equals("")) {
            line = scanner.nextLine();
        }
        return lineStringToLottoLine(line);
    }

    public LottoLine getWinnerLine() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String line = scanner.nextLine();
        if (line.equals("")) {
            line = scanner.nextLine();
        }

        return lineStringToLottoLine(line);
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextInt();
    }
}
