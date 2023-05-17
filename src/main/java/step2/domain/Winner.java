package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final ArrayList<LottoNumber> winnerNumbers;
    private static final int LOTTO_LENGTH = 6;
    public Winner(List<Integer> integers) {

        checkSize(integers);
        this.winnerNumbers = new ArrayList<>();

        for (Integer integer : integers) {
            this.winnerNumbers.add(new LottoNumber(integer));
        }
//        this.winnerNumbers = integers;

    }

    private static void checkSize(List<Integer> integers) {
        if (integers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("6개 입력하세요");
        }
    }

    public int match(Lotto lotto) {

        return lotto.compareLottoNumbers(this.winnerNumbers);
    }
}
