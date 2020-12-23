package com.ssabae.nextstep.lotto.domain.lotto;

import com.ssabae.nextstep.lotto.Constant;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-17
 */
public class LottoTicket {

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != Constant.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
        if (!isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<LottoNumber> numbers) {
        int length = numbers.size();
        return numbers.stream().distinct().toArray().length == length;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
