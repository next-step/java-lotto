package step3.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuyLotto extends Lotto{
    private static final int BONUS_BALL = 5;
    private List<LottoNumberList> buyLottoList;

    public BuyLotto(int totalCount) {
        Lotto lotto = new Lotto();
        List<LottoNumberList> buyLottoList = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            LottoNumberList lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        this.buyLottoList = buyLottoList;
    }

    public BuyLotto(int totalCount, String[] manulaLottoNumbers) {
        this(totalCount);
        addManual(manulaLottoNumbers);
    }

    private void addManual(String[] manulaLottoNumbers) {
        for (int i = 0; i < manulaLottoNumbers.length; i++) {
            buyManualLotto(manulaLottoNumbers[i]);
        }
    }

    private void buyManualLotto(String manulaLottoNumber1) {
        List<LottoNumber> manulaLottoNumber = new ArrayList<>();
        String[] splitString = split(manulaLottoNumber1);
        for (int i = 0; i < splitString.length; i++) {
            LottoNumber number = LottoNumber.of(Integer.parseInt(splitString[i]));
            manulaLottoNumber.add(number);
        }
        this.buyLottoList.add(new LottoNumberList(manulaLottoNumber));
    }

    private String[] split(String inputValue) {
        String[] splitString;
        try {
            splitString = inputValue.split(SPLIT_SIGN);
            if (splitString.length != SELECT_NUMBER) {
                throw new IllegalArgumentException("당첨번호형식이 틀렸습니다.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return splitString;
    }


    public List<LottoNumberList> getBuyLottoList() {
        return buyLottoList;
    }

    public List<RankInformation> check(WinLotto winLotto) {
        Iterator<LottoNumberList> iterator = buyLottoList.iterator();
        List<RankInformation> list = new ArrayList<>();
        while (iterator.hasNext()) {
            RankInformation rankInformation = matchWinInformation(winLotto, iterator.next());
            list.add(rankInformation);
        }
        return list;
    }

    private RankInformation matchWinInformation(WinLotto winLotto, LottoNumberList next) {
        int matchCount = winLotto.match(next);
        boolean bonusBallMatch = false;
        if (matchCount == BONUS_BALL) {
            bonusBallMatch = winLotto.matchBonusball(next);
        }
        return RankInformation.matchWinInformation(matchCount, bonusBallMatch);
    }
}
