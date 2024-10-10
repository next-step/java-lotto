package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoGame {
    public static final String CAN_NOT_BUY_LOTTO = "로또를 살 수 없는 금액입니다.";
    public static final String CAN_NOT_BUY_LOTTO_AMOUNT = "로또는 1000원 단위로 구입 가능합니다.";
    private static final int gamePrice = 1000;
    private final int gameMoney;
    private final List<Lotto> lottoList;
    private final LottoResults lottoResults;

    public LottoGame(int gameMoney) {
        this(gameMoney, new LottoResults(new HashMap<>()));
    }

    public LottoGame(int gameMoney, LottoResults lottoResults){
        this.gameMoney = validateGameMoney(gameMoney);
        this.lottoList = generateLotto(gameMoney / gamePrice);
        this.lottoResults = lottoResults;
    }

    private List<Lotto> generateLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    private int validateGameMoney(int gameMoney) {
        if (gameMoney <= 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO);
        }
        if (gameMoney % 1000 != 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO_AMOUNT);
        }
        return gameMoney;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void makeLottoResult(Lotto winningLotto){
        for(int i=0;i<lottoList.size();i++){
            lottoResults.addResult(lottoList.get(i).getLottoResult(winningLotto));
        }
    }
}
