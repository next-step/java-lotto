package lotto;

import java.util.Scanner;

import lotto.model.LottoNumbers;
import lotto.view.LottoNumberView;

public class Lotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");

        int paymentAmount = scanner.nextInt();
        int lottoQuantity = LottoVendingMachine.calculate(paymentAmount);
        System.out.println(String.format("%d개를 구매했습니다.", lottoQuantity));

        // create Lotter numbers
        LottoNumbers lottoNumbers = LottoVendingMachine.buy(lottoQuantity);

        System.out.println(new LottoNumberView(lottoNumbers.getLottoNumbers()).toView());
    }
}
