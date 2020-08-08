package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import camp.nextstep.edu.rebellion.lotto.rule.LottoGameRule;

public class LottoNumber {
    private final Integer number;

    public LottoNumber(int number) {
        checkRange(number);
        this.number = Integer.valueOf(number);
    }

    public LottoNumber(String str) {
        this(Integer.parseInt(str));
    }

    public boolean equals(LottoNumber n) {
        return this.number == n.number;
    }

    public int getNumber() {
        return this.number.intValue();
    }

    private int checkRange(int number) {
        if (LottoGameRule.getLottoNumberMin() > number || LottoGameRule.getLottoNumberMax() < number) {
            throw new IllegalArgumentException("당첨번호가 잘못되었습니다 " + number);
        }
        return number;
    }

    @Override
    public int hashCode() {
        return number.intValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }

        return (obj instanceof LottoNumber &&
                ((LottoNumber) obj).number == this.number);
    }
}
