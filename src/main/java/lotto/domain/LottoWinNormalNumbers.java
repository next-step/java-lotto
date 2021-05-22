package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoGameOptions.*;

public class LottoWinNormalNumbers {

    private List<LottoNumber> normalNumbers = new ArrayList<>();

    public LottoWinNormalNumbers(String numbers) {
        initWinNumbers(numbers.split(", |,"));
    }

    private void initWinNumbers(String[] winNums) {
        if (invalid(winNums)) {
            throw new IllegalArgumentException("로또 당첨 일반번호의 개수로 유효하지 않습니다.");
        }

        for (String winNum : winNums) {
            add(Integer.parseInt(winNum));
        }
    }

    private boolean invalid(String[] numberStrings) {
        return numberStrings.length != LOTTO_NUMBER_COUNT;
    }

    public void add(int num) {
        normalNumbers.add(LottoNumber.of(num));
    }

    public Stream<LottoNumber> stream() {
        return normalNumbers.stream();
    }

    public boolean contains(int bonusNumber) {
        return this.normalNumbers.contains(LottoNumber.of(bonusNumber));
    }
}
