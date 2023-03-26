package lotto;

import lotto.model.Level;
import lotto.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HitLotto {
    private static final long LOTTO_AMOUNT = 1000;

    private static final long LOTTO_NUMBER_COUNT = 6;


    // 당첨번호 변환: 입력 받은 당첨번호를 숫자 리스트로 변환
    public List<Integer> convertWinningNumbers(String winningNumbers) {

        List<Integer> winningNumber = Arrays.stream(winningNumbers.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        for (int number : winningNumber) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("1 ~ 45 만 입력 가능");
            }
        }

        if (winningNumber.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("중복 번호 존재");
        }

        return winningNumber;
    }

    // 로또 구매 수
    public long getPurchaseCount(long amount) {

        return amount / LOTTO_AMOUNT;
    }

    // 구매한 수만큼 로또 생성
    public List<LottoNumber> getLotto(long purchaseCount) {

        List<LottoNumber> lottoNumbers = new ArrayList<>();

//        LongStream.rangeClosed(1, purchaseCount)
//                .forEach(it -> lottoNumbers.add(createLottoNumber()));
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(createLottoNumber());
        }

        return lottoNumbers;
    }

    // 로또 번호 생성
    private LottoNumber createLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.rangeClosed(1, 45)
                .forEach(numbers::add);

        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, 6);
        Collections.sort(lottoNumbers);

        return new LottoNumber(lottoNumbers, Level.hitCount(0));
    }
}
