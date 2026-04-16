package com.practise.conditionalbeancreation;

import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CustomCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        String value = context.getEnvironment().getProperty("custom.flag");
        return "true".equalsIgnoreCase(value);
    }
}
