package com.vosievskaya.rsa.generator;

import java.math.BigInteger;

public class Key {

    private BigInteger component;
    private BigInteger modulus;

    public Key(BigInteger component, BigInteger modulus) {
        this.component = component;
        this.modulus = modulus;
    }

    public BigInteger getComponent() {
        return component;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    @Override
    public String toString() {
        return "Key{" +
                "component=" + component +
                ", modulus=" + modulus +
                '}';
    }
}
