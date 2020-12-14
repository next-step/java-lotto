package com.ssabae.nextstep.stringcalculator.validator;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-14
 */
public interface Validator<T> {

    boolean validate(T t);

}
