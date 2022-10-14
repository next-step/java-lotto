package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratedLottoNumberResponseView implements ResponseView {
    private final List<List<Integer>> lottoNumbers;

    public GeneratedLottoNumberResponseView(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toView() {
        return lottoNumbers.stream()
                           .map(this::convertLottoNumberToView)
                           .collect(Collectors.joining("\n"));
    }

    private String convertLottoNumberToView(List<Integer> lottoNumber) {
        return String.join(", ", Arrays.toString(lottoNumber.toArray()));
    }
}
