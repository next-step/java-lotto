package lotto.model;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String COMMA = ",";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String RIGHT_SQUARE_BRACKET = "]";

    private final List<LottoNumber> numbers;

    Lotto(LottoNumberGeneratingStrategy lottoNumberGeneratingStrategy) {
        this.numbers = lottoNumberGeneratingStrategy.generateNumbers();
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    int findEqualNumberCount(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> equalLottoNumbers = lottoNumbers.stream()
                .filter(numbers::contains)
                .collect(toList());
        return equalLottoNumbers.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LEFT_SQUARE_BRACKET);
        for (LottoNumber number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(COMMA);
            stringBuilder.append(ONE_BLANK_SPACE);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(COMMA));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(ONE_BLANK_SPACE));
        stringBuilder.append(RIGHT_SQUARE_BRACKET);
        return stringBuilder.toString();
    }
}
