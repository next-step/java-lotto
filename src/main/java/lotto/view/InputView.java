package lotto.view;

import lotto.domain.LottoCenter;

import java.util.Scanner;

public class InputView {

    public int buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int cash = scanner.nextInt();
        int issuedTicket = new LottoCenter().buyLotto(cash);

        System.out.println(issuedTicket + "개를 구매했습니다.");
        return issuedTicket;
    }
}
