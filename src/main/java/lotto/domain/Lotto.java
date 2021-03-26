package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumberList;

    public Lotto(int[] lottoNumbers) {
        this.lottoNumberList = Arrays.stream(lottoNumbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public int[] getLottoNumbers() {
        return lottoNumberList.stream().mapToInt(LottoNumber::getLottoNumber).sorted().toArray();
    }

    public LottoRank inquiryRank(int[] winNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumberList) {
            matchCount+=Arrays.stream(winNumbers).filter(winNumber -> lottoNumber.getLottoNumber() == winNumber).count();
        }
        return LottoRank.getEnum(matchCount);
    }
}
