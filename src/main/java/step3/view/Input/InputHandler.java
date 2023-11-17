package step3.view.Input;

import java.util.Optional;
import java.util.function.Supplier;

public class InputHandler<T> {

    public Optional<T> input(String question, Supplier<T> inputProcess){

        System.out.println(question);
        Optional<T> result = Optional.empty();

        boolean isInputValid = false;
        while(!isInputValid){
            try{
                result = Optional.of(inputProcess.get());
                isInputValid = true;
            }catch (Exception e){
                System.out.println(question);
            }
        }
        return result;
    }
}
