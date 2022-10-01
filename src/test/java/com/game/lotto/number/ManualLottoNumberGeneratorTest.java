package com.game.lotto.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumberGeneratorTest {

    private final String[] lottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
    private ManualLottoNumberGenerator manualLottoNumberGenerator;

    @BeforeEach
    void set_up() {
        manualLottoNumberGenerator = new ManualLottoNumberGenerator(lottoNumbers);
    }

    @Test
    void manual_number_generation() {
        List<Integer> generatedNumbers = manualLottoNumberGenerator.generateNumbers();
        for (int index = 0; index < generatedNumbers.size(); index++) {
            assertEquals(Integer.parseInt(lottoNumbers[index]), generatedNumbers.get(index));
        }
    }
}