package lotto.model;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String COMMA = ",";
    private static final String ONE_BLANK_SPACE = " ";
    private static final String RIGHT_SQUARE_BRACKET = "]";

    private final List<LottoNumber> numbers;

    Lotto() {
        this.numbers = generateNumbers();
    }

    Lotto(List<LottoNumber> lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    private List<LottoNumber> generateNumbers() {
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        List<LottoNumber> numbers = allLottoNumbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(toList());
        Collections.sort(numbers);

        return numbers;
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    int getNumbersSize() {
        return numbers.size();
    }

    int getEqualNumberCount(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> equalLottoNumbers = lottoNumbers.stream()
                .filter(numbers::contains)
                .collect(toList());
        return equalLottoNumbers.size();
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(LEFT_SQUARE_BRACKET);
        for (LottoNumber number : numbers) {
            stringBuffer.append(number);
            stringBuffer.append(COMMA);
            stringBuffer.append(ONE_BLANK_SPACE);
        }
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(COMMA));
        stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(ONE_BLANK_SPACE));
        stringBuffer.append(RIGHT_SQUARE_BRACKET);
        return stringBuffer.toString();
    }
}
