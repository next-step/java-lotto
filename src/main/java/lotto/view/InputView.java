package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
  private static final Scanner sc = new Scanner(System.in);

  public static Money getPurchaseAmount() {
    System.out.println("구입 금액을 입력해 주세요.");
    return new Money(Integer.parseInt(sc.nextLine()));
  }

  public static List<LottoTicket> getManualLottoTickets() {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    int manualTicketCount = Integer.parseInt(sc.nextLine());

    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    List manualLottoTickets = new ArrayList();
    for (int i = 0; i < manualTicketCount; i++) {
      manualLottoTickets.add(new LottoTicket(Arrays.stream(sc.nextLine().split(", "))
                                                   .map(LottoNumber::from)
                                                   .collect(Collectors.toList())
      ));
    }
    return manualLottoTickets;
  }

  public static LottoNumbers getLastWeekWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return new LottoNumbers(Arrays.stream(sc.nextLine().split(", "))
                                  .map(LottoNumber::from)
                                  .collect(Collectors.toList())
    );
  }

  public static LottoNumber getBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return LottoNumber.from(sc.nextLine());
  }
}
