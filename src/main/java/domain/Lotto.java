package domain;

import java.util.*;

public class Lotto {

     final static int SINGLE_LOTTO_SIZE = 6;
     final static int LOTTO_MAX_BOUND = 45;
     final static List<Integer> LOTTO_NUMBERS = new ArrayList<>(LOTTO_MAX_BOUND);
     static {
          for(int i = 0 ; i < LOTTO_MAX_BOUND ; i++) {
               LOTTO_NUMBERS.add(i+1);
          }
     }

     private List<Integer> numbers = new ArrayList<>();

     public Lotto(List<Integer> numbers){
          this.numbers = numbers;
          Collections.sort(numbers);
     }

     public Lotto(){

          Collections.shuffle(LOTTO_NUMBERS);

          for(int i = 0 ; i < SINGLE_LOTTO_SIZE ; i++) {
               numbers.add(LOTTO_NUMBERS.get(i));
          }

          Collections.sort(numbers);
     }

     public List<Integer> getNumbers() {
          return numbers;
     }

     @Override
     public String toString() {
          return numbers.toString();
     }

     public boolean contains(int number) {
          return numbers.contains(number);
     }

}
