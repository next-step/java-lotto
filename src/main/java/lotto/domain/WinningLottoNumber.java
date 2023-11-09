package lotto.domain;

import java.util.List;

public class WinningLottoNumber {

    private final List<Integer> numbers;

    public WinningLottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoRank winningRank(LottoNumber lottoNumber) {
        int count = 0;
        for(int number : numbers) {
            if(lottoNumber.contains(number)) count++;
        }

        return LottoRank.searchBy(count);
    }
}
