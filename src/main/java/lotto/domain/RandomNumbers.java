package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomNumbers {

        private List<Integer> values;

        public RandomNumbers() {
                generateOneAutoNumber();
        }

        public RandomNumbers(List<Integer> values) {
                this.values = values;
        }

        public List<Integer> values() {
                return values;
        }

        private void generateOneAutoNumber() {
                for (int i = 1; i <= 45; i++) {
                        values.add(i);
                }
                Collections.shuffle(values);
                values = values.subList(0, 6);
                Collections.sort(values);
        }
}
