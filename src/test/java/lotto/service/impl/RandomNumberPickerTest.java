package lotto.service.impl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberPickerTest {

    @Test
    void test(){
        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
        List<Integer> pick = randomNumberPicker.pick();
        System.out.println("pick = " + pick);
        pick.set(0,10);
        System.out.println("pick = " + pick);
    }
}
