package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private static List<Integer> generateLottoNumberArray() {
        List<Integer> lottoNumArray = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            lottoNumArray.add(i + 1);
        }
        return lottoNumArray;
    }

    public static List<Lotto> generateLottoNumbers(int numberOfTicket) {
        List<Integer> lottoNumArray = generateLottoNumberArray();
        List<Lotto> lottoTickets = new ArrayList<>();
        List<Integer> shuffleLottoNumber;

//        while(numberOfTicket-- > 0) {
//            Collections.shuffle(lottoNumArray);
//            shuffleLottoNumber = lottoNumArray.subList(0, 5);
//            shuffleLottoNumber.remove(0);
//            lottoTickets.add(new Lotto(shuffleLottoNumber));
//        }

        return lottoTickets;
    }

//    public static List<Lotto> generateLottoNumbers(int numberOfTickets) {
    // lotto 번호를 가진 리스트를 넘버만큼 반복해 생성한다.
    // 해당 List<Lotto> lottoTickets 를 반환한다.
//    }
}
