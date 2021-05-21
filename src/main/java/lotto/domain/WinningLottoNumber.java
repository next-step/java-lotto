package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static lotto.domain.LottoNumber.from;

public class WinningLottoNumber {
    private static final String COMMA = ",";

    private List<LottoNumber> values;

    public WinningLottoNumber(String playerInput) {
        parseValues(playerInput);
    }

    private void parseValues(String playerInput) {
        this.values = Arrays.stream(playerInput.split(COMMA))
                .map(each->from(parseInt(each)))
                .collect(Collectors.toList());
    }
}
