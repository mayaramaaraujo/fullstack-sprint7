package br.com.rchlo.store.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Card {

    private String clientName;
    @Column(length = 16)
    private String number;
    private String expiration;
    @Column(length = 3)
    private String verificationCode;

    public Card(String clientName, String number, String expiration, String verificationCode) {
        this.clientName = clientName;
        this.number = number;
        this.expiration = expiration;
        this.verificationCode = verificationCode;
    }

    public Card() {
    }
}
