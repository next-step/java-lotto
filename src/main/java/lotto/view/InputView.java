package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoNumbers;
import lotto.utils.LottoNumbersUtil;

public class InputView {
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Long getBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = this.scanner.nextLine();
        return Long.parseLong(inputText);
    }

    public String getWinningNumber() {
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public int getManualLottoCount() {
        System.out.println("");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(this.scanner.nextLine());
    }

    public List<LottoNumbers> getManualLottoNumbers(int manualCount) {
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumbers> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualNumbers.add(LottoNumbersUtil.toLottoNumbers(this.scanner.nextLine()));
        }
        return manualNumbers;
    }
}
