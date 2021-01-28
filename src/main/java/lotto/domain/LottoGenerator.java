package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int LOWER_BOUND_LOTTO = 1;
    public static final int UPPER_BOUND_LOTTO = 46;
    public static final int LOTTO_CAPACITY = 6;

    private final List<LottoNumber> possibleLottoNumbers = new ArrayList<>();

    public LottoGenerator() {
        for (int i = LOWER_BOUND_LOTTO; i < UPPER_BOUND_LOTTO; i++) {
            possibleLottoNumbers.add(new LottoNumber(i));
        }
    }

    private PlayersLotto generateLottoOneLotto() {
        Collections.shuffle(possibleLottoNumbers);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i = 0; i < LOTTO_CAPACITY; i++) {
            lottoNumbers.add(possibleLottoNumbers.get(i));
        }
        return new PlayersLotto(lottoNumbers);

    }

    public List<PlayersLotto> generateLottoTickets(int numberOfTicket) {
        // 1로또를 만든다
        // 이 것을 리스트형태로 넘버오브티켓만큼 반복한다
        List<PlayersLotto> playersLottoTickets = new ArrayList<>();

        for(int i = 0; i < numberOfTicket; i++) {
            PlayersLotto playersLotto = generateLottoOneLotto();
            playersLottoTickets.add(playersLotto);
        }
        return playersLottoTickets;

//        while(numberOfTicket-- > 0) {
//            Collections.shuffle(lottoNumArray);
//            shuffleLottoNumber = lottoNumArray.subList(0, 5);
//            shuffleLottoNumber.remove(0);
//            lottoTickets.add(new Lotto(shuffleLottoNumber));
//        }
    }


//    public static List<Lotto> generateLottoNumbers(int numberOfTickets) {
    // lotto 번호를 가진 리스트를 넘버만큼 반복해 생성한다.
    // 해당 List<Lotto> lottoTickets 를 반환한다.
//    }
}
