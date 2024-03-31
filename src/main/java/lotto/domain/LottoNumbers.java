//package lotto.domain;
//
//import java.util.*;
//
//public class LottoNumbers {
//
//    private final static int LOTTO_NUMBER_LIMIT = 6;
//
//    List<LottoNumber> lottoNumbers;
//
//    public LottoNumbers() {
//        this.lottoNumbers = lottoNumbers;
//    }
//    public void generate() {
//        HashSet<Integer> randomNumber = new HashSet<>();
//        Random rand = new Random();
//
//        while (randomNumber.size() < LOTTO_NUMBER_LIMIT) {
//            int number = rand.nextInt(LOTTO_BOUND_NUMBER) ;
//            randomNumber.add(number);
//        }
//        lottoNumbers =  new ArrayList<>(randomNumber);
//        Collections.shuffle(lottoNumbers);
//    }
//
//
//
//}
