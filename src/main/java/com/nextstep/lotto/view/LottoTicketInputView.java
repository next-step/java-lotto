package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoTicket;
import com.nextstep.lotto.domain.StaticCreatePolicy;
import com.nextstep.lotto.view.exceptions.InvalidLottoNumbersException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketInputView {
    private final List<Integer> lottoNumbers;

    public LottoTicketInputView(final String userValue) {
        validateValue(userValue);
        List<Integer> lottoNumbers = parseToNumbers(userValue);
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = parseToNumbers(userValue);
    }

    public LottoTicket parseToLottoTicket() {
        StaticCreatePolicy createPolicy = new StaticCreatePolicy(lottoNumbers);
        return LottoTicket.of(createPolicy);
    }

    private void validateValue(final String userValue) {
        if (userValue.isEmpty()) {
            throw new InvalidLottoNumbersException("빈 문자열은 입력되지 않습니다.");
        }
    }

    private void validateLottoNumbers(final List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new InvalidLottoNumbersException("로또 번호는 총 6개를 입력하셔야 합니다.");
        }
    }

    private List<Integer> parseToNumbers(final String lottoNumbers) {
        try {
            return Arrays.stream(lottoNumbers.split(", "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidLottoNumbersException("숫자만 입력 가능합니다.");
        }
    }
}
