package Model;

import View.Input.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("14개의 로또 생성 TEST")
    void addLotto() {
        //given
        int count = 4;
        Lotto[] lottos = new Lotto[count];
        //when
        Integer[] arr01 = {8, 21, 23, 41, 42, 43};
        ArrayList<Integer> Lotto01 = new ArrayList<>(Arrays.asList(arr01));

        //then
        for (Lotto lotto : lottos)
            System.out.println(lotto.getLotto());

    }
}