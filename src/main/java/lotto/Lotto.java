package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> initlottoNumber = IntStream.range(1, 45).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumbers;
    private int winnerMatchCnt;
    private Rank rank;

    public Lotto(boolean auto) {
        if(auto){
            lottoNumbers = autoGenerateLottoNumber();
        }else{
        // 수동입력 추후 구현
            lottoNumbers = new ArrayList<>();
        }

    }

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public List<Integer> autoGenerateLottoNumber() {
        Collections.shuffle(initlottoNumber);
        return initlottoNumber.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void addWinnerMatchCnt(int winnerMatchCnt) {
        this.winnerMatchCnt = winnerMatchCnt;
    }

    public int getWinnerMatchCnt() {
        return winnerMatchCnt;
    }
}
