package com.ssabae.nextstep.lotto.domain.lotto;

import java.util.Arrays;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-17
 */
public class LottoTicket {

    private final LottoNumber[] numbers;

    public LottoTicket(LottoNumber ...numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public LottoNumber[] getNumbers() {
        return numbers;
    }

    private void validate(LottoNumber[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers);
    }
}
