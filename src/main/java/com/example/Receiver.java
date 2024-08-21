package com.example;

import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Receiver {

    byte[] getKey(KEM.Encapsulated encapsulated, java.security.PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException {
        final var receiversKem = KEM.getInstance("DHKEM");
        final var receiver = receiversKem.newDecapsulator(privateKey);
        final var receivedSecretKey = receiver.decapsulate(encapsulated.encapsulation());
        return receivedSecretKey.getEncoded();
    }


}
