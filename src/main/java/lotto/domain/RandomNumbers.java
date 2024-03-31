package lotto.domain;

import java.util.*;

public class RandomNumbers {
    private final static int LOTTO_BOUND_NUMBER = 45;
    private final static int LOTTO_NUMBER_LIMIT = 5;
    List<Integer> lottoNumbers = new ArrayList<>();

    public RandomNumbers() {
        HashSet<Integer> randomNumber = new HashSet<>();
        Random rand = new Random();

        while (randomNumber.size() < LOTTO_NUMBER_LIMIT) {
            int number = rand.nextInt(LOTTO_BOUND_NUMBER) ; // Generate a number between 1 and 50
            randomNumber.add(number);
        }
        lottoNumbers =  new ArrayList<>(randomNumber);
        Collections.shuffle(lottoNumbers);
    }
//    public static void main(String[] args) {
//        HashSet<Integer> lottoNumbers = new HashSet<>();
//        Random rand = new Random();
//
//        while (lottoNumbers.size() < 5) {
//            int number = rand.nextInt(50) + 1; // Generate a number between 1 and 50
//            lottoNumbers.add(number);
//        }
//
//        List<Integer> sortedNumbers = new ArrayList<>(lottoNumbers);
//        Collections.sort(sortedNumbers);
//        System.out.println(sortedNumbers);
//    }
}
