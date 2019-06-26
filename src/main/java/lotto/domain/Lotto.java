package lotto.domain;

import java.util.*;

public class Lotto {

    protected LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public Lotto() {
        this(new LottoNumber());
    }

    void checkAnotherNumberLength(List<Integer> numbers) throws IllegalArgumentException {
        Set anotherNums = new HashSet();
        for (Integer number : numbers) {
            anotherNums.add(number);
        }
        if (anotherNums.size() != LottoNumber.MAX_LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("1부터 45사이의 서로 다른 6개의 숫자만 로또번호로 인정됩니다.");
        }
    }

    Rank getRank(LottoNumber winLottoNumber, Integer bonusNumber) {
        boolean matchBonus = false;
        if (lottoNumber.getNumbers().contains(bonusNumber)) {
            matchBonus = true;
        }
        List<Integer> sameWinNumbers = new ArrayList<>();
        sameWinNumbers.addAll(lottoNumber.getNumbers());
        sameWinNumbers.retainAll(winLottoNumber.getNumbers());
        return Rank.valueOf(sameWinNumbers.size(), matchBonus);
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
