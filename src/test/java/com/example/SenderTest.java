package com.example;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class SenderTest {

    @Test
    void testGetKey() throws NoSuchAlgorithmException, InvalidKeyException {
        final var keyPairGenerator = KeyPairGenerator.getInstance("X25519");
        final var keyPair = keyPairGenerator.generateKeyPair();
        final var  publicKey = keyPair.getPublic();
        final var  privateKey = keyPair.getPrivate();

        final var sendersKey = new Sender().getKey(publicKey);
        final var receiversKey = new Receiver().getKey(sendersKey, privateKey);

        assertArrayEquals(sendersKey, receiversKey);
    }


}
