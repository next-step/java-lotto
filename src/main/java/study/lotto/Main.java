package study.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import study.lotto.controller.LottoController;
import study.lotto.model.LottoGeneral;
import study.lotto.model.LottoNumber;
import study.lotto.service.LottoService;
import study.lotto.service.LottoServiceImpl;
import study.lotto.view.InputView;
import study.lotto.view.InputViewImpl;
import study.lotto.view.OutputView;
import study.lotto.view.OutputViewImpl;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputViewImpl();
    OutputView outputView = new OutputViewImpl();
    LottoService lottoService = new LottoServiceImpl(lottoGeneralBean());
    LottoController lottoController = new LottoController(inputView, outputView, lottoService);
    lottoController.run();
  }

  private static LottoGeneral lottoGeneralBean() {
    List<Integer> numbers = new ArrayList<>();
    IntStream.rangeClosed(1,45).forEach(numbers::add);
    return () -> {
      Collections.shuffle(numbers);
      int[] result = numbers.subList(0, 6).stream().mapToInt(Integer::intValue).toArray();
      Arrays.sort(result);
      return new LottoNumber(result);
    };
  }
}
