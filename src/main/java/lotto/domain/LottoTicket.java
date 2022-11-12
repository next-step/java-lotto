package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket){
        validationNullCheck(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void validationNullCheck (List<Integer> lottoTicket){
        if(lottoTicket.isEmpty()){
            throw new NullPointerException("로또가 생성 되지 않았습니다.");
        }
    }

    public static LottoTicket lottoMake(){
        List<Integer> lottoNumbers = IntStream.range(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return new LottoTicket(lottoNumbers.subList(0,6));
    }

    public int lottoNumberMatchCount(WinningNumbers winningNumbers){
        return (int) this.lottoTicket.stream()
                .filter(i -> winningNumbers.getWinningNumbers().contains(i))
                .count();
    }

    public List<Integer> getTicket() {
        return lottoTicket;
    }

    @Override
    public String toString() {
        return lottoTicket.toString();
    }
}
