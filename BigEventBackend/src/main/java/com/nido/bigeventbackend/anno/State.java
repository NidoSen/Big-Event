package com.nido.bigeventbackend.anno;

import com.nido.bigeventbackend.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented // 元注解
@Constraint(validatedBy = {StateValidation.class})
@Target({ElementType.FIELD}) // 元注解
@Retention(RetentionPolicy.RUNTIME) // 元注解
public @interface State {

    // 提供校验失败后的提示信息
    String message() default "state的值只能是已发布或者草稿";

    // 指定分组
    Class<?>[] groups() default {};

    // 负载，获取到State的注解信息
    Class<? extends Payload>[] payload() default {};
}
