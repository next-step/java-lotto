package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.view.InputView;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator{

  private final InputView inputView;

  public ManualLottoGenerator(InputView inputView) {
    this.inputView = inputView;
  }

  @Override
  public Lotto generate() {
    List<LottoNumber> numbers = inputView.receiveManualNumbers();
    return new Lotto(numbers);
  }
}
