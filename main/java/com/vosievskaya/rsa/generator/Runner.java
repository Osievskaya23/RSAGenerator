package com.vosievskaya.rsa.generator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Runner {

    private static KeyPair keyPair;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RSA generator");

        JLabel messageLabel = new JLabel("Enter your message, please)");
        JLabel privateKeyLabel = new JLabel();
        JLabel publicKeyLabel = new JLabel();

        JTextField messageData = new JTextField();
        JTextField encodedData = new JTextField();
        JTextField decodedData = new JTextField();

        JButton generateButton = new JButton("Generate key pair");
        JButton encodeButton = new JButton("Encrypt");
        JButton decodeButton = new JButton("Decrypt");

        messageLabel.setBounds(35, 10, 200, 40);
        messageData.setBounds(30, 40, 420, 40);

        generateButton.setBounds(150, 80, 200, 40);
        publicKeyLabel.setBounds(35, 110, 700, 40);
        privateKeyLabel.setBounds(35, 130, 700, 40);

        encodeButton.setBounds(35, 170, 200, 40);
        decodeButton.setBounds(250, 170, 200, 40);

        encodedData.setBounds(30, 210, 420, 40);
        decodedData.setBounds(30, 260, 420, 40);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RSAGenerator rsaGenerator = new RSAGenerator();
                keyPair = rsaGenerator.generateKeyPair(128);
                publicKeyLabel.setText("Public key:  " + keyPair.getPublicKey().toString());
                privateKeyLabel.setText("Private key: " + keyPair.getPrivateKey().toString());
            }
        });

        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encodedData.setText(keyPair.encrypt(messageData.getText()).toString());
            }
        });

        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger decrypted = keyPair.decrypt(new BigInteger(encodedData.getText()));
                String result = "";
                for(byte b: decrypted.toByteArray()){
                    result += (char) b;
                }
                decodedData.setText(result);
            }
        });

        frame.add(messageLabel);
        frame.add(messageData);
        frame.add(generateButton);
        frame.add(privateKeyLabel);
        frame.add(publicKeyLabel);
        frame.add(encodeButton);
        frame.add(decodeButton);
        frame.add(encodedData);
        frame.add(decodedData);

        frame.setSize(500, 350);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
