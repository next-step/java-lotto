package stringsumcalculator;

import stringsumcalculator.model.Separators;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class SeparatorsTest {

    @Test
    @DisplayName("구분자 생성이 제대로 되는가")
    public void createSeparator(){
        //Separators separators = new Separators("//;\\n1;2;3");

        String string = "//[\\n1[2[3";
        Separators separators = new Separators(string);

        assertEquals(separators.getSeparator(0),"[");

        String string2 = "1,2,3";
        Separators separators2 = new Separators(string2);

        assertEquals(separators2.getSeparator(0),",");
        assertEquals(separators2.getSeparator(1),":");
    }

}
