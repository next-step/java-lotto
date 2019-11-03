package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    List<Integer> lottoNum = new ArrayList<Integer>();

    public LottoTicket() {
    }

    public int[] makeAutoNumbers() {
        // List 안에 로또번호 추가
        for (int i = 1; i <= 45; i++) {
            lottoNum.add(i);
        }

        // set안의 수를 무작위로 섞는다
        Collections.shuffle(lottoNum);

        int[] lottoNums = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoNums[i] = lottoNum.get(i);
        }

        // 정렬
        Arrays.sort(lottoNums);

        return Arrays.toString(lottoNums);
    }
}
