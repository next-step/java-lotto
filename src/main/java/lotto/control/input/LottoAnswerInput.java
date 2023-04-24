package lotto.control.input;

import lotto.model.Lotto;
import lotto.view.View;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class LottoAnswerInput extends InputControl<Lotto> {
    private static final String LOTTO_DELIMITER = ",";

    public LottoAnswerInput(View view) {
        this.view = view;
    }

    @Override
    protected Lotto input() {
        String input = scanner.nextLine();
        List<Integer> lottoNumbers = parseLottoNumbers(input);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> parseLottoNumbers(String input) {
        String[] inputSplit = input.split(LOTTO_DELIMITER);
        return stream(inputSplit)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }

}
