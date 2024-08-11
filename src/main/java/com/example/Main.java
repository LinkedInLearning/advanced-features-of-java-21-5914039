package com.example;


import javax.crypto.KEM;
import java.security.KeyPairGenerator;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Throwable {

        final var keyPairGenerator = KeyPairGenerator.getInstance("X25519");
        final var keyPair = keyPairGenerator.generateKeyPair();
        final var  publicKey = keyPair.getPublic();
        final var  privateKey = keyPair.getPrivate();

        final var sendersKem = KEM.getInstance("DHKEM");
        final var sender = sendersKem.newEncapsulator(publicKey);
        final var encapsulated = sender.encapsulate();
        final var secretKey = encapsulated.key();

        final var receiversKem = KEM.getInstance("DHKEM");
        final var receiver = receiversKem.newDecapsulator(privateKey);
        final var receivedSecretKey = receiver.decapsulate(encapsulated.encapsulation());

        if (Arrays.equals(secretKey.getEncoded(), receivedSecretKey.getEncoded())) {
            System.out.println("Keys match!");
        } else {
            System.out.println("Keys don't match!");
        }

    }

}
