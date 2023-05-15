package lotto.domain.generator;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberCache;
import lotto.util.Util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ManualLottoGenerator implements LottoGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 숫자의 입력값은 6개로 이루어져야 합니다.";
    private static final String SPLIT_REGEX = ", ";
    private final Scanner scanner = new Scanner(System.in);
    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    @Override
    public Set<LottoNumber> generate() {
        String input = scanner.nextLine();
        String[] lottoNumbers = input.split(SPLIT_REGEX);
        Arrays.stream(lottoNumbers).forEach(lottoNumber -> this.lottoNumbers.add(LottoNumberCache.valueOf(Util.convertInt(lottoNumber))));
        lottoSizeCheck();
        return this.lottoNumbers;
    }

    private void lottoSizeCheck() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalStateException(LOTTO_SIZE_ERROR);
        }
    }


}
