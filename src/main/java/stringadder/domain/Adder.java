package stringadder.domain;


import java.util.List;
import java.util.stream.Collectors;
import stringadder.utils.exception.InputValidException;

public class Adder {

    public static int add(List<String> numbers){

        if(numbers.contains(" ") ||
            numbers.contains("") ||
            numbers.contains(null)
        ) {
            return 0;
        }


        List<Integer> convertInt = numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
        convertInt.stream().peek(InputValidException::inputNegativeValidation).collect(Collectors.toList());

        return convertInt.stream().mapToInt(Integer::intValue).sum();
    }



}
