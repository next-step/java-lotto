package com.nextstep.lotto.lottoGame.view;

import com.nextstep.lotto.lottoGame.domain.LottoTicket;
import com.nextstep.lotto.lottoGame.domain.WinningNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int getBudget() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<LottoTicket> getManualLottoNumbers(final int count) {
        List<LottoTicket> manualTickets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            String[] split = scanner.nextLine().split(",");
            List<Integer> lottoNumbers = Arrays.stream(split)
                    .map(InputView::toUnsignedInteger)
                    .collect(Collectors.toList());
            manualTickets.add(new LottoTicket(lottoNumbers));
        }

        return manualTickets;
    }

    public static WinningNumbers getLottoNumbers() {
        System.out.println("지난주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        List<Integer> lottoNumbers = Arrays.stream(split)
                .map(InputView::toUnsignedInteger)
                .collect(Collectors.toList());

        System.out.println("보너스 번호를 입력하세요.");
        int bonusNumber = scanner.nextInt();

        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    private static int toUnsignedInteger(String numericString) {
        try {
            return Integer.parseUnsignedInt(numericString.replaceAll("\\s", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
