package me.daeho.lotto.view;

import me.daeho.lotto.domain.LottoPurchase;
import me.daeho.lotto.domain.LottoNumber;
import me.daeho.lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final static String DELIMITER = ",";

    public static LottoPurchase purchase() {
        System.out.println("구입금액을 입력해 주세요");
        int amount = new Scanner(System.in).nextInt();

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = new Scanner(System.in).nextInt();

        System.out.println("수동으로 구매할 로또 번호를 입력해 주세요.");
        final List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottoTickets.add(LottoTicket.issue(inputLottoNumber()));
        }

        return LottoPurchase.of(amount, manualCount, manualLottoTickets);
    }

    public static List<LottoNumber> lastWeekWinningNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return inputLottoNumber();
    }

    private static List<LottoNumber> inputLottoNumber() {
        return Arrays.stream(new Scanner(System.in).nextLine().split(DELIMITER))
                .map(Integer::valueOf)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static LottoNumber bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(new Scanner(System.in).nextInt());
    }
}
