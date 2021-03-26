package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoNumberList;

    public Lotto(int[] lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
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

    public static void validateLottoNumbers(int[] winNumbers) {
        if(winNumbers==null || winNumbers.length==0) {
            throw new IllegalArgumentException("당첨 숫자를 입력해 주세요.");
        }
        if(winNumbers.length != LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("당첨 숫자는 6개의 수 여야 합니다.");
        }
        if(Arrays.stream(winNumbers).distinct().count() < LottoConstant.MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다. 입력값을 확인해주세요.");
        }
        for (int winNumber : winNumbers) {
            LottoNumber.validateLottoNumber(winNumber);
        }
    }
}
