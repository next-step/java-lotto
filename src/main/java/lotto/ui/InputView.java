package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.ManualPurchaseNumber;
import lotto.domain.Money;

public class InputView {

  public Money buy() {
    Printer.print("구입금액을 입력해 주세요.");
    return Money.from(Reader.read());
  }

  public List<LottoNumber> lastWeekNumbers() {
    Printer.print("지난 주 당첨 번호를 입력해 주세요.");

    return readLottoNumbers();
  }

  public LottoNumber bonusNumber() {
    Printer.print("보너스 볼을 입력해 주세요.");
    return LottoNumbers.pick(Reader.read());
  }

  public ManualPurchaseNumber manualPurchaseNumber(int ticketPurchasableNumber) {
    Printer.print("수동으로 구매할 로또 수를 입력해 주세요.");
    return new ManualPurchaseNumber(Reader.read(), ticketPurchasableNumber);
  }


  public List<List<LottoNumber>> manualLottoTickets(ManualPurchaseNumber manualPurchaseNumber) {
    Printer.print("수동으로 구매할 번호를 입력해 주세요.\n");

    List<List<LottoNumber>> manualLottoNumbersGroups = new ArrayList<>();
    for (int i = 0; i < manualPurchaseNumber.value(); i++) {
      manualLottoNumbersGroups.add(readLottoNumbers());
    }

    return manualLottoNumbersGroups;
  }

  private List<LottoNumber> readLottoNumbers() {
    return Arrays.stream(
            Reader.read().split(", "))
        .map(LottoNumbers::pick)
        .collect(Collectors.toList());
  }
}
