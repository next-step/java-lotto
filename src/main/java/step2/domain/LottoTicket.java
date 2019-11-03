package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    List<Integer> lottoNum = new ArrayList<Integer>();

    public LottoTicket() {
    }

    public int[] makeAutoNumbers() {
        for (int i = 1; i <= 45; i++) {
            lottoNum.add(i);
        }

        Collections.shuffle(lottoNum);

        int[] lottoNums = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoNums[i] = lottoNum.get(i);
        }

        Collections.sort(lottoNum);

        return lottoNums;
    }
}
