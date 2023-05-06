package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningNumber;

    public WinningLotto(String winningNumbers) {
        this(split(winningNumbers));
    }

    public WinningLotto(List<Integer> winningNumber) {
        List<LottoNumber> result = new ArrayList<>();
        for (Integer n : winningNumber) {
            result.add(new LottoNumber(n));
        }
        this.winningNumber = result;
    }

    private static List<Integer> split(String winningNumbers) {
        String[] split = winningNumbers.replaceAll(" ","").split(",");
        List<Integer> result = new ArrayList<>();
        for (String s : split) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }

    public int matchCount(List<Lotto> lottos, int count){
        int result = 0;
        for (Lotto lotto : lottos) {
            if(count == match(lotto)){
                result++;
            }
        }
        return result;
    }

    int match(Lotto lotto) {
        int result = 0;
        for (LottoNumber lottoNumber : winningNumber) {
            if(lotto.contain(lottoNumber)){
                result++;
            }
        }
        return result;
    }

}
