package step2.model.view;

import java.util.List;

public class Input {

  int userAmount;
  int userManualLottoCount;
  List userManualLottoNumbers;
  String[] lottowinningNumbers;
  int lottowinningBonusNumbers;

  public Input(int userAmount, List userManualLottoNumbers) {
    this.userAmount = userAmount;
    this.userManualLottoCount = userManualLottoNumbers.size();
    this.userManualLottoNumbers = userManualLottoNumbers;
  }

  public Input(int userAmount, int userManualLottoCount, List userManualLottoNumbers) {
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

  public List getUserManualLottoNumbers() {
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
