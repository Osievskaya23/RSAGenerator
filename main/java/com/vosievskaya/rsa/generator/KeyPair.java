package com.vosievskaya.rsa.generator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class KeyPair {

    private Key privateKey;
    private Key publicKey;

    public BigInteger encrypt(String message) {
        return new BigInteger(message.getBytes()).modPow(publicKey.getComponent(), publicKey.getModulus());
    }

    public BigInteger decrypt(BigInteger message) {
        return message.modPow(privateKey.getComponent(), privateKey.getModulus());
    }
}
