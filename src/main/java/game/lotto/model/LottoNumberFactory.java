package game.lotto.model;

import game.lotto.util.RandomNumberGenerator;
import game.lotto.util.WinningNumberSplitor;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumberFactory {

    public static Set<LottoNumber> createRandomLottoNumbers() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();

        while (lottoNumbers.size() != Lotto.NUMBER_SIZE) {
            int randomNumber = RandomNumberGenerator.generateStartWithOne(LottoNumber.MAX);
            LottoNumber lottoNumber = new LottoNumber(randomNumber);

            if (lottoNumbers.contains(lottoNumber)) {
                continue;
            }

            lottoNumbers.add(lottoNumber);
        }

        return lottoNumbers;
    }

    public static Set<LottoNumber> createWinningLottoNumbers(String stringWinningNumbers) {
        String[] winningNumbers = WinningNumberSplitor.split(stringWinningNumbers);

        if(winningNumbers.length != Lotto.NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 로또 번호 갯수는 6개입니다.");
        }

        Set<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers)
                                                .mapToInt(Integer::parseInt)
                                                .mapToObj(LottoNumber::new)
                                                .collect(Collectors.toCollection(TreeSet::new));

        if(lottoNumbers.size() < Lotto.NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 당첨 번호가 존재합니다.");
        }
        return lottoNumbers;
    }

}
