package step2.model.view;

import java.util.List;
import step2.model.lotto.LottoNos;

public class Input {

  private int userAmount;
  private int userManualLottoCount;
  private List<LottoNos> userManualLottoNumbers;
  private String[] lottowinningNumbers;
  private int lottowinningBonusNumbers;

  public Input(int userAmount, int userManualLottoCount, List<LottoNos> userManualLottoNumbers) {
    this.userAmount = userAmount;
    this.userManualLottoCount = userManualLottoCount;
    this.userManualLottoNumbers = userManualLottoNumbers;
  }

  public int getUserAmount() {
    return userAmount;
  }

  public int getUserManualLottoCount() {
    return userManualLottoCount;
  }

  public List<LottoNos> getUserManualLottoNumbers() {
    return userManualLottoNumbers;
  }

  public String[] getLottowinningNumbers() {
    return lottowinningNumbers;
  }

  public void setLottowinningNumbers(String[] lottowinningNumbers) {
    this.lottowinningNumbers = lottowinningNumbers;
  }

  public int getLottowinningBonusNumbers() {
    return lottowinningBonusNumbers;
  }

  public void setLottowinningBonusNumbers(int lottowinningBonusNumbers) {
    this.lottowinningBonusNumbers = lottowinningBonusNumbers;
  }
}
