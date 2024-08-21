package com.example;

import org.junit.jupiter.api.Test;

import javax.crypto.DecapsulateException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class ReceiverTest {

    @Test
    void testGetKey() throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException {
        final var keyPairGenerator = KeyPairGenerator.getInstance("X25519");
        final var keyPair = keyPairGenerator.generateKeyPair();
        final var  publicKey = keyPair.getPublic();
        final var  privateKey = keyPair.getPrivate();

        final var encapsulated = new Sender().getKey(publicKey);
        final var receiversKey = new Receiver().getKey(encapsulated, privateKey);

        assertArrayEquals(encapsulated.key().getEncoded(), receiversKey);
    }

}
