package step2.domain;

import step2.domain.Lotto.LottoNumber;
import step2.exception.ListNullPointerException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputLottoNumbers {
    private static final String COMMA = ",";
    private final List<LottoNumber> inputLottoNumbers;

    private InputLottoNumbers(List<LottoNumber> inputLottoNumbers) {
        if (isListNull(inputLottoNumbers)) {
            throw new ListNullPointerException();
        }
        this.inputLottoNumbers = inputLottoNumbers;
    }

    public InputLottoNumbers(String sentence) {
        this(toLottoNumberList(sentence));
    }

    private static List<LottoNumber> toLottoNumberList(String sentence) {
        return Stream.of(sentence.split(COMMA))
                .map(String::trim)
                .map(Integer::valueOf)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static final InputLottoNumbers newInstance(List<LottoNumber> InputLottoNumbers) {
        return new InputLottoNumbers(InputLottoNumbers);
    }

    public static final InputLottoNumbers newInstance(String sentence) {
        return new InputLottoNumbers(sentence);
    }

    private final boolean isListNull(List<LottoNumber> inputLottoNumbers) {
        return inputLottoNumbers == null;
    }

}
