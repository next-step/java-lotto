package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> lottoNumbers;
    private int winnerMatchCnt;
    private Rank rank;

    public Lotto(boolean auto) {
        if(auto){
            autoGenerateLottoNumber();
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

    public void autoGenerateLottoNumber() {
        List<Integer> lottoNumber = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumber);
        lottoNumbers = lottoNumber.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setWinnerMatchCnt(int winnerMatchCnt) {
        this.winnerMatchCnt = winnerMatchCnt;
    }

    public int getWinnerMatchCnt() {
        return winnerMatchCnt;
    }
}
