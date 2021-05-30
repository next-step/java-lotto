package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lotto.domain.LottoManualCount;
import lotto.domain.LottoNumber;
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
        validateBuyPrice(inputText);
        return Long.parseLong(inputText);
    }

    public List<LottoNumbers> getManualLottoNumbers(Price buyPrice) {
        LottoManualCount manualLottoCount = new LottoManualCount(getManualLottoCount(buyPrice));
        if (!manualLottoCount.hasBuyCount()) {
            return new ArrayList<>();
        }
        System.out.println("");
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return createManualLottoNumbers(manualLottoCount.manualCount());
    }

    public LottoNumbers getWinningNumber() {
        System.out.println("");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return LottoNumbersUtil.toLottoNumbers(this.scanner.nextLine());
    }

    public LottoNumber getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumberText = this.scanner.nextLine();
        validateBonusNumber(bonusNumberText);
        return new LottoNumber(bonusNumberText);
    }

    private int getManualLottoCount(Price buyPrice) {
        System.out.println("");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualLottoCount = this.scanner.nextLine();
        validateManualLottoCount(buyPrice, manualLottoCount);
        return Integer.parseInt(manualLottoCount);
    }

    private List<LottoNumbers> createManualLottoNumbers(int manualLottoCount) {
        List<LottoNumbers> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualNumbers.add(LottoNumbersUtil.toLottoNumbers(this.scanner.nextLine()));
        }
        return manualNumbers;
    }

    private void validateBonusNumber(String bonusNumberText) {
        if (!ValidationUtil.isIntegerNumber(bonusNumberText)) {
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
    }

    private void validateBuyPrice(String textBuyPrice) {
        if (!ValidationUtil.isLongNumber(textBuyPrice)) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }

    private void validateManualLottoCount(Price buyPrice, String manualLottoCount) {
        if (!ValidationUtil.isIntegerNumber(manualLottoCount)) {
            throw new IllegalArgumentException("구매할 로또 개수는 숫자만 입력 가능합니다.");
        }
        if (!buyPrice.canBuy(Integer.parseInt(manualLottoCount))) {
            throw new IllegalArgumentException("구입금액으로 살 수 있는 양을 초과 입력하였습니다.");
        }
    }
}
