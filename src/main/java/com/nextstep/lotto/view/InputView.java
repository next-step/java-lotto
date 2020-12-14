package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoNumber;
import com.nextstep.lotto.domain.LottoTicket;
import com.nextstep.lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Money getMoney() {
        MoneyInputView moneyInputView = new MoneyInputView(SCANNER.nextLine());
        return moneyInputView.parseMoney();
    }

    public static LottoTicket getLottoTicket() {
        LottoTicketInputView lottoTicketInputView = new LottoTicketInputView(SCANNER.nextLine());
        return lottoTicketInputView.parseToLottoTicket();
    }

    public static LottoNumber getBonusNumber() {
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView(SCANNER.nextInt());
        return bonusNumberInputView.parseToBonusNumber();
    }

    public static int getNumberOfStaticLotto() {
        int numberOfStaticLotto = SCANNER.nextInt();
        eraseEmptyLine();

        return new NumberOfStaticLotto(numberOfStaticLotto).getValue();
    }

    private static void eraseEmptyLine() {
        SCANNER.nextLine(); // 사용자가 숫자와 함께 입력한 엔터를 없애기 위한 조치
    }
}
