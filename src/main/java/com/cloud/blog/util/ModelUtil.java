package com.cloud.blog.util;

/**
 * @author 成都犀牛
 * @version version 1.0
 * @date 2020/10/6 18:30
 */
public class ModelUtil<T,R> {
    private T firstValue;
    private R lastValue;

    public ModelUtil() {
    }

    public ModelUtil(T firstValue, R lastValue) {
        this.firstValue = firstValue;
        this.lastValue = lastValue;
    }

    public T getFirstValue() {
        return firstValue;
    }

    public ModelUtil<T, R> setFirstValue(T firstValue) {
        this.firstValue = firstValue;
        return this;
    }

    public R getLastValue() {
        return lastValue;
    }

    public ModelUtil<T, R> setLastValue(R lastValue) {
        this.lastValue = lastValue;
        return this;
    }

    @Override
    public String toString() {
        return "ModelUtil{" +
                "firstValue=" + firstValue +
                ", lastValue=" + lastValue +
                '}';
    }
}
