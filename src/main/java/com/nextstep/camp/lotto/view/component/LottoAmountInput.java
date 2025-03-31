package com.nextstep.camp.lotto.view.component;

import com.nextstep.camp.common.utils.NumberUtils;
import com.nextstep.camp.common.view.component.AbstractInput;
import com.nextstep.camp.lotto.domain.exception.NotNumberFormatStringException;
import com.nextstep.camp.lotto.domain.vo.LottoAmount;

import java.util.Scanner;

public class LottoAmountInput extends AbstractInput<LottoAmount> {

    // 0 초과 정수 1000단위
    private static final String LOTTO_AMOUNT_REGEX = "^[1-9]\\\\d{0,}000$";

    private LottoAmountInput(Scanner scanner) {
        super(scanner);
    }

    public static LottoAmountInput create(Scanner scanner) {
        return new LottoAmountInput(scanner);
    }

    @Override
    protected boolean isValid(String value) {
        return value.matches(LOTTO_AMOUNT_REGEX);
    }

    @Override
    public String getLabel() {
        return "구입금액을 입력해 주세요.";
    }

    @Override
    public LottoAmount getValue() {
        validate();
        int intValue = Integer.parseInt(untypedValue);
        return LottoAmount.of(intValue);
    }

    private void validate() {
        if (NumberUtils.isNotNumber(untypedValue)) {
            throw new NotNumberFormatStringException();
        }
    }
}
