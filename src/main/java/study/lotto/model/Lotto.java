package study.lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  int count = 0;
  List<LottoNumber> numbers = new ArrayList<>();

  public Lotto(int count, LottoGeneral lottoGeneral) {
    this.count = count;
    this.generateLottoNumbers(count, lottoGeneral);
  }

  private void generateLottoNumbers(int count, LottoGeneral lottoGeneral) {
    for (int i = 0; i < count; i++) {
      numbers.add(lottoGeneral.generate());
    }
  }

  public int getCount() {
    return this.count;
  }

  public String list() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.count; i++) {
      LottoNumber lottoNumber = numbers.get(i);
      String numberString = lottoNumber.numberString();
      sb.append(numberString).append("\n");
    }

    return sb.toString();
  }

  public List<LottoNumber> getNumbers() {
    return numbers;
  }
}
