package domain;

import policy.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    //금액에 맞게 로또를 여러번 객체 생성을 하고,
    //다 만든 이후에 카운트를 해서 result에 갯수를 뿌려준 뒤
    // 로또 리스트를 출력함.
    private static final List<Lotto> lottoTickets = new ArrayList<>();
    private final int MAX_COUNT = 6;

    public LottoService() {

    }

    public List<Lotto> generateLotto(int count) {
        List<Integer> lottoNumbers = LottoNumber.generateLottoNumber();
        Collections.sort(lottoNumbers);

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(lottoNumbers);
            lottoTickets.add(lotto);
        }

        return lottoTickets;
    }
}
