package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNo {

    private int number;

    public LottoNo(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNo> generateLottoNos(List<Integer> numbers){
        return numbers.stream()
                .map(LottoNo::new)
                .collect(Collectors.toList());

    }

    public static List<Integer> changeInLottoNosBy(List<LottoNo> lottoNos){
        return lottoNos.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());

    }
}
