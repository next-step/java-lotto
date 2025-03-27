package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private List<Integer> lottoNumbers = new ArrayList<>();

  public Lotto(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public Lotto(DrawingStrategy drawingStrategy) {
    this.lottoNumbers = drawingStrategy.draw();
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }


}
