package lotto.domain;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static final int NUMBER_OF_LOTTO = 6;
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;

    private Set<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new HashSet<>(lotto);

        isValidSize();
    }

    public Lotto(String[] lottoStrArr){
        this(Arrays.stream(lottoStrArr)
                .map(i -> LottoNumber.of(Integer.parseInt(i)))
                .collect(Collectors.toList()));
    }

    private void isValidSize(){
        if(this.lotto.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException("Lotto must be contain unique 6 numbers");
        }
    }

    @Override
    public String toString() {
        String lottoStr = lotto.stream()
                .sorted()
                .map(LottoNumber::toString)
                .collect(Collectors.toList())
                .toString();

        return lottoStr;
    }

    public boolean isContains(LottoNumber lottoNumber) {
       return lotto.contains(lottoNumber);
    }

    public Count match(Lotto compareLotto){
        Count count = Count.ZERO;

        for(LottoNumber num : lotto){
            count = compareLotto.updateCount(num, count);
        }

        return count;
    }

    private Count updateCount(LottoNumber num, Count count) {
        if(isContains(num)){
            count = count.increase();
        }

        return  count;
    }
}
