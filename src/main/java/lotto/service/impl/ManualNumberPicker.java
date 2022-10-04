package lotto.service.impl;

import lotto.controller.InputView;
import lotto.model.LottoBall;
import lotto.service.LottoNumberPicker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberPicker implements LottoNumberPicker {

    private final InputView inputView;

    public ManualNumberPicker(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public List<LottoBall> pick() {
        try {
            return pick(inputView.getSplitedInput());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 입력 번호는 숫자여야만 합니다.", e);
        }
    }

    List<LottoBall> pick(String[] input) {
        return Arrays.stream(input)
                .map((num) -> new LottoBall(Integer.valueOf(num.trim())))
                .collect(Collectors.toList());
    }
}
