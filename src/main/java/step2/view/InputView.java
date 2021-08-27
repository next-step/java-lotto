package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import step2.model.lotto.LottoNo;
import step2.model.lotto.LottoNos;
import step2.model.view.Input;

public class InputView {

  private static final String COMMA = ",";

  private Scanner scanner = new Scanner(System.in);

  LottoNos getUserLottoNumbers(String[] userLottoNumbers) {
    List<LottoNo> userLottoNumberList = new ArrayList();
    for (String userLottoNumber : userLottoNumbers) {
      userLottoNumberList.add(new LottoNo(Integer.parseInt(userLottoNumber)));
    }
    return new LottoNos(userLottoNumberList);
  }

  public Input getUserInput() {
    int userAmount = inputUserAmount();
    int userManualLottoCount = inputUserManualLottoCount();
    List userManualLottoNumbers = inputUserManualLottoNumbers(userManualLottoCount);

    return new Input(userAmount, userManualLottoCount, userManualLottoNumbers);
  }

  public int inputUserAmount() {
    System.out.println("\n구입금액을 입력해 주세요.");
    return scanner.nextInt();
  }

  public int inputUserManualLottoCount() {
    System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    return scanner.nextInt();
  }

  public List<LottoNos> inputUserManualLottoNumbers(int userManualLottoCount) {
    System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");

    List<LottoNos> lottoNosList = new ArrayList();
    for (int i = 0; i < userManualLottoCount; i++) {
      String[] userLottoNumbers = scanner.next().split(COMMA);
      lottoNosList.add(getUserLottoNumbers(userLottoNumbers));
    }

    return lottoNosList;
  }

  public void setUserWinningInput(Input userInput) {
    String[] lottowinningNumbers = inputLottoWinningNumber();
    int lottowinningBonusNumbers = inputLottoWinningBonusNumber();

    userInput.setLottowinningNumbers(lottowinningNumbers);
    userInput.setLottowinningBonusNumbers(lottowinningBonusNumbers);
  }


  public String[] inputLottoWinningNumber() {
    System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    return scanner.next().split(COMMA);
  }

  public int inputLottoWinningBonusNumber() {
    System.out.println("\n보너스 볼을 입력해 주세요.");
    return scanner.nextInt();
  }
}
