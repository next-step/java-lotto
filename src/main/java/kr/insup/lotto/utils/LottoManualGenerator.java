package kr.insup.lotto.utils;

import java.util.List;

public class LottoManualGenerator implements NumberGenerator {

    List<Integer> numbers;

    public LottoManualGenerator(String stringNumber) throws NumberFormatException{
        this(LottoNumberParser.parseLottoNumberToList(stringNumber));
    }

    public LottoManualGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumber() {
        return numbers;
    }
}
