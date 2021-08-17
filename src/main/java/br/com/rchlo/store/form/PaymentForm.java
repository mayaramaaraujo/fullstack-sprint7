package br.com.rchlo.store.form;

import br.com.rchlo.store.domain.Card;
import br.com.rchlo.store.domain.Payment;
import br.com.rchlo.store.domain.PaymentStatus;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class PaymentForm {

  @NotNull
  private BigDecimal value;

  @NotNull
  @Size(max = 100)
  @NotEmpty
  private String clientName;

  @NotNull
  @NotEmpty
  private String number;

  @NotNull
  @NotEmpty
  private String expiration;

  @NotNull
  @NotEmpty
  private String verificationCode;

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public String getVerificationCode() {
    return verificationCode;
  }

  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }

  public Payment toConvert() {
    return new Payment(this.value, PaymentStatus.CREATED, new Card(this.clientName, this.number, this.expiration, this.verificationCode));
  }
}
