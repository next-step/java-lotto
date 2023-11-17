package step3.view.Input;

import java.util.Optional;

public class InputHandler<T> {

    public Optional<T> input(String question, InputProcess<T> inputProcess){

        System.out.println(question);
        Optional<T> result = Optional.empty();

        boolean isInputValid = false;
        while(!isInputValid){
            try{
                result = Optional.of(inputProcess.input());
                isInputValid = true;
            }catch (Exception e){
                System.out.println(question);
            }
        }
        return result;
    }
}
