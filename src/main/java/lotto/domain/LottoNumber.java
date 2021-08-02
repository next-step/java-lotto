package lotto.domain;

import lotto.exception.LottoNumberRangeException;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER  = 1;
    private static final int MAX_LOTTO_NUMBER  = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if(lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER){
            throw new LottoNumberRangeException();
        }
    }


//    public LottoNumber() {
//        shuffled();
//        picked();
//    }

//    private void picked() {
//
//    }
//
//    private void shuffled() {
//        List<Integer> shuffledNumbers = new ArrayList<>();
//        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
//            shuffledNumbers.add(i);
//        }
//
//        Collections.shuffle(shuffledNumbers);
//
//        pickedNumbers = shuffledNumbers.subList(0, COUNT_OF_PICK);
//        Collections.sort(pickedNumbers);
//
//    }
//
//    public LottoNumber(List<Integer> lottoNumbers) {
//        this.pickedNumbers = lottoNumbers;
//    }
//
//
//    public String value() {
//        return pickedNumbers.toString();
//    }
//
//    public long countOfMatch(LottoNumber winningLottoNumber) {
//
//        return winningLottoNumber.pickedNumbers.stream()
//                .filter(number -> this.pickedNumbers.contains(number))
//                .count();
//
//    }
}
