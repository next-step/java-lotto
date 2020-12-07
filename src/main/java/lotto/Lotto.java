package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private final List<LottoNumber> initlottoNumber = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().map(LottoNumber::new).collect(Collectors.toList());
    private final List<LottoNumber> lottoNumbers;
    private LottoNumber bonusLottoNumber;

    public Lotto(boolean auto) {
        if(auto){
            lottoNumbers = autoGenerateLottoNumber();
        }else{
        // 수동입력 추후 구현
            lottoNumbers = new ArrayList<>();
        }

    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoNumber[] winnerLotto, LottoNumber bonusLottoNumber) {
        this.lottoNumbers = Arrays.stream(winnerLotto).collect(Collectors.toList());
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public List<LottoNumber> autoGenerateLottoNumber() {
        Collections.shuffle(initlottoNumber);
        return initlottoNumber.stream()
                .limit(6)
                .sorted(Comparator.comparing(LottoNumber::toInt))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Rank> matchingWinnerNumber(LottoTicket lottoTicket){
        List<Rank> lottoRankList = new ArrayList<>();
        for(Lotto lotto : lottoTicket.getLottoList()){
            int matchCnt = getMatchLottoCnt(lotto);
            lottoRankList.add(Rank.valueOf(matchCnt, isContainBonusNumber(lotto, bonusLottoNumber)));
        }
        return lottoRankList;
    }

    public int getMatchLottoCnt(Lotto lotto) {
        return this.lottoNumbers.stream().mapToInt(i -> {
            return judgeWinnerNumber(lotto, i);
        }).sum();
    }

    private static Integer judgeWinnerNumber(Lotto lotto, LottoNumber i) {
        if(isContainBonusNumber(lotto, i)){
            return 1;
        }
        return 0;
    }

    private static boolean isContainBonusNumber(Lotto lotto, LottoNumber bonusLottoNumber){

        return lotto.getLottoNumbers().stream().filter(n -> n.toString().equals(bonusLottoNumber.toString())).findFirst().isPresent();
    }


}
