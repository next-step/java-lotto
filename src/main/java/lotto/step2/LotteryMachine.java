package lotto.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryMachine {
    public List<List<LottoNumber>> issueLotto(int numberOfIssues, ShuffleStrategy shuffleStrategy) {
        List<List<LottoNumber>> issueLotto = new ArrayList<>();
        List<LottoNumber> lottoNumbers = LottoNumbersFactory.create();
        List<LottoNumber> shuffle = shuffleStrategy.shuffle(lottoNumbers);
        
        for (int i = 0; i < numberOfIssues; i++) {
            List<LottoNumber> collect = IntStream.rangeClosed(0, 6)
                    .mapToObj(shuffle::get)
                    .collect(Collectors.toList());
            issueLotto.add(collect);
        }
        return issueLotto;
    }
}
