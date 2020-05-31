package lotto.step4.view;

import lotto.step4.domain.Lotto;
import lotto.step4.domain.LottoGenerator;
import lotto.step4.domain.LottoNumber;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class InputView {

  private static InputView instance;
  private static final Scanner scanner = new Scanner(System.in);

  private InputView () {}

  public int inputPrice () {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(scanner.nextLine());
  }

  public List<Lotto> inputLottoYourOwn () {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    int length = Integer.parseInt(scanner.nextLine());

    System.out.println("\n로또 번호를 입력해 주세요.");
    return Stream.generate(InputView::inputLotto)
                 .limit(length)
                 .collect(toList());
  }

  private static Lotto inputLotto () {
    return LottoGenerator.generateLotto(scanner.nextLine());
  }

  public String inputWinning () {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    return scanner.nextLine();
  }

  public LottoNumber inputBonus () {
    System.out.println("보너스 볼을 입력해 주세요.");
    return LottoNumber.valueOf(scanner.nextLine());
  }

  public static InputView getInstance () {
    if (instance == null) instance = new InputView();
    return instance;
  }
}
