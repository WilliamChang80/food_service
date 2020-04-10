package com.food.service.demo.domain.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class BaseDto {
    private final Object data;
    private final boolean isSuccess;
    private final int status;

}
