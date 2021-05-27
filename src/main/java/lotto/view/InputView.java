package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoManualCount;
import lotto.domain.LottoNumbers;
import lotto.domain.Price;
import lotto.utils.LottoNumbersUtil;
import lotto.utils.ValidationUtil;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Long getBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputText = this.scanner.nextLine();
        if (!ValidationUtil.isLongNumber(inputText)) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
        return Long.parseLong(inputText);
    }

    public int getManualLottoCount(Price buyPrice) {
        System.out.println("");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualLottoCount = this.scanner.nextLine();
        if (!ValidationUtil.isIntegerNumber(manualLottoCount)) {
            throw new IllegalArgumentException("구매할 로또 개수는 숫자만 입력 가능합니다.");
        }
        if (!buyPrice.canBuy(Integer.parseInt(manualLottoCount))) {
            throw new IllegalArgumentException("구입금액으로 살 수 있는 양을 초과 입력하였습니다.");
        }
        return Integer.parseInt(manualLottoCount);
    }

    public List<LottoNumbers> getManualLottoNumbers(LottoManualCount manualCount) {
        if (!manualCount.hasBuyCount()) {
            return new ArrayList<>();
        }
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumbers> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount.manualCount(); i++) {
            manualNumbers.add(LottoNumbersUtil.toLottoNumbers(this.scanner.nextLine()));
        }
        return manualNumbers;
    }

    public String getWinningNumber() {
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.nextLine();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberText = this.scanner.nextLine();
        if (!ValidationUtil.isIntegerNumber(bonusNumberText)) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
        return Integer.parseInt(bonusNumberText);
    }
}
