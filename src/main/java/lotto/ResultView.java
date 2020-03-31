package lotto;

import java.util.Map;

public class ResultView {
    private final Numbers numbers;
    private Lotto lotto;

    public ResultView(String inputText) {
        this(inputText, null);
    }

    public ResultView(String inputText, Lotto lotto) {
        this.numbers = getParsedNumbers(inputText);
        this.lotto = lotto;
    }

    public Map<Integer, LottoNumbers> getWinLottos() {
        LottoResult lottoResult = new LottoResult(winnerNumber(), lotto);

        return lottoResult.checkWinnerLotto();
    }

    public LottoNumbers winnerNumber() {
        return new LottoNumbers(numbers.getNumbers());
    }

    private Numbers getParsedNumbers(String inputText) {
        return new Parser(inputText).getNumbers();
    }

}
