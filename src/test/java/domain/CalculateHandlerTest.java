package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateHandlerTest {

    CalculateHandler calculateHandler;

    @BeforeEach
    void setUp() {
        calculateHandler = new CalculateHandler();
    }

    @Test
    @DisplayName("2개의 연산자가 포핟된 복잡한 연산")
    void complex1(){
        final String[] inputs = {"2", "+", "2", "/", "2"};
        for(String input : inputs){
            calculateHandler.handle(input);
        }
        assertThat(calculateHandler.getResult()).isEqualTo(2);
    }

    @Test
    @DisplayName("3개의 연산자가 포핟된 복잡한 연산")
    void complex2(){
        final String[] inputs = {"2", "+", "2", "-", "1", "*", "5"};
        for(String input : inputs){
            calculateHandler.handle(input);
        }
        assertThat(calculateHandler.getResult()).isEqualTo(15);
    }

    @Test
    @DisplayName("숫자가 연속으로 들어올때")
    void number_in_a_row(){
        final String[] inputs = {"2", "2", "3"};
        assertThatThrownBy(()->{
            for(String input : inputs){
                calculateHandler.handle(input);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 연속으로 들어올때")
    void operator_in_a_row(){
        final String[] inputs = {"2", "*", "+"};
        assertThatThrownBy(()->{
            for(String input : inputs){
                calculateHandler.handle(input);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("연산자가 가장 처음에 있을때")
    void operation_place_first(){
        final String[] inputs = {"*", "2", "+", "3"};
        assertThatThrownBy(()->{
            for(String input : inputs){
                calculateHandler.handle(input);
            }
        }).isInstanceOf(IllegalArgumentException.class);
    }
}