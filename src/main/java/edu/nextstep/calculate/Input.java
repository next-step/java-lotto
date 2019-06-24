package edu.nextstep.calculate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 21:44
 */
public class Input {

    private List<String> input;

    public Input(List<String> input) {
        this.input = new ArrayList<>(input);
    }

    public List<String> getInputData() {
        return Collections.unmodifiableList(this.input);
    }
}
