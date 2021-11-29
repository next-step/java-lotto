package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String STARTING_BRACKET ="[";
    private static final String LAST_BRACKET ="]";
    private static final String SPLITERATOR_OF_LOTTO_NUMBERS = ", ";
    private static final int STARTING_INDEX_STRING = 0;
    private static final int STARTING_INDEX_FOR_INSERTING_SPLITERATOR = 1;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new ArrayList<>();
        numbers.forEach(number ->
                this.lottoNumbers.add(new LottoNumber(number)));
        Collections.sort(lottoNumbers);
    }

    public int compareWithWinningNumber(Lotto winningNumber) {
        return (int) winningNumber.lottoNumbers
                .stream()
                .filter(this.lottoNumbers::contains)
                .count();
    }

    public String provideNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STARTING_BRACKET);
        stringBuilder.append(lottoNumbers.get(STARTING_INDEX_STRING));

        for (int i = STARTING_INDEX_FOR_INSERTING_SPLITERATOR; i < lottoNumbers.size(); i++) {
            stringBuilder.append(SPLITERATOR_OF_LOTTO_NUMBERS);
            stringBuilder.append(lottoNumbers.get(i));
        }
        stringBuilder.append(LAST_BRACKET);

        return stringBuilder.toString();
    }
}
