package lotto.service.impl;

import lotto.controller.InputView;
import lotto.model.LottoBall;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualNumberPickerTest {

    @Test
    void shouldPickNumber(){
        ManualNumberPicker picker = new ManualNumberPicker(getInputView());
        List<LottoBall> lottoBalls = picker.pick(new String[]{"1", "2", "3"});

        assertThat(lottoBalls).isEqualTo(List.of(new LottoBall(1),new LottoBall(2),new LottoBall(3)));
    }

    private InputView getInputView() {
        return new InputView(new BufferedReader(new InputStreamReader(System.in)));
    }
}
