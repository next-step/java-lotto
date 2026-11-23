import javax.xml.validation.Validator;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;



    public Lotto() {
        numbers = createNumbers();
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> createNumbers() {
        // 숫자를 만드는 과정;

        return null;
    }


    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 0 || number > 45) {
                throw new IllegalArgumentException("1부터 45까지의 로또만 생성이 가능하다.");
            }
        }


        if (numbers.size() > 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 생성되어야한다.");
        }
    }



}
