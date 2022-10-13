package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberView {
    private final List<List<Integer>> lottoNumbers;

    public LottoNumberView(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String toView() {
        return lottoNumbers.stream()
                           .map(this::convertLottoNumberToView)
                           .collect(Collectors.joining("\n"));
    }

    private String convertLottoNumberToView(List<Integer> lottoNumber) {
        return String.join(", ", Arrays.toString(lottoNumber.toArray()));
    }
}
