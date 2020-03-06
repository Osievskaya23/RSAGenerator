package com.vosievskaya.rsa.generator;

import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.SecureRandom;

import static java.math.BigInteger.ONE;

public class RSAGenerator {

    private KeyPair keyPair;

    public KeyPair generateKeyPair(int numbits) {
        BigInteger p = BigInteger.probablePrime(numbits, new SecureRandom());
        BigInteger q = BigInteger.probablePrime(numbits, new SecureRandom());

        BigInteger n = p.multiply(q);

        BigInteger pMinusOne = p.subtract(ONE);
        BigInteger qMinusOne = q.subtract(ONE);
//        BigInteger phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        BigInteger phiN = pMinusOne.multiply(qMinusOne);

        BigInteger e;

        do {
            e = BigInteger.probablePrime(numbits, new SecureRandom());
        } while ((e.compareTo(ONE) == 1) &&
                (e.compareTo(phiN) == -1) &&
                (e.gcd(phiN).compareTo(ONE) != 0));
        BigInteger d = e.modInverse(phiN);

        keyPair = new KeyPair(new Key(e, n), new Key(d, n));
        return keyPair;
    }

}
