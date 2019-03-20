package domain;

import java.util.*;

public class Lotto {

     final static int SINGLE_LOTTO_SIZE = 6;
     final static int LOTTO_MAX_BOUND = 45;

     private List<Integer> numbers;

     public Lotto(List<Integer> numbers){
          this.numbers = numbers;
          Collections.sort(numbers);
     }

     public Lotto(){
          Set<Integer> tmpNumbers = new HashSet<>();
          while( tmpNumbers.size() < SINGLE_LOTTO_SIZE){
               tmpNumbers.add( (int) (Math.random() * LOTTO_MAX_BOUND) + 1 );
          }
          numbers = new ArrayList<>(tmpNumbers);
          Collections.sort(numbers);
     }

     public List<Integer> getNumbers() {
          return numbers;
     }


     @Override
     public String toString() {
          return numbers.toString();
     }
}
