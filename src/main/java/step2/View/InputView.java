package step2.View;

import step2.Domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Money buyLotto() {
        System.out.println("구매 금액을 입력해주세요.");
        return Optional.of(new Money(scanner.nextLine())).orElseGet(()->new Money(0));
    }

    public PurchasedLottoNumber buyManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new PurchasedLottoNumber(scanner.nextLine());
    }

    public WinningLotto winningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new WinningLotto(new Lotto(new InputNumber(scanner.nextLine())), bonusBall());
    }

    private LottoNumber bonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        return new LottoNumber(scanner.nextLine());
    }

    public List<InputNumber> inputLottoNumbers(PurchasedLottoNumber manualBuyNumber) {
        List<InputNumber> manualList = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualBuyNumber.getNumber(); i++) {
            String input = scanner.nextLine();
            manualList.add(new InputNumber(input));
        }
        return manualList;
    }
}
