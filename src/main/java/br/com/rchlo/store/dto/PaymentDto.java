package br.com.rchlo.store.dto;

import br.com.rchlo.store.domain.Payment;
import br.com.rchlo.store.domain.PaymentStatus;


import java.math.BigDecimal;

public class PaymentDto {

  private BigDecimal value;
  private PaymentStatus status;

  public PaymentDto(Payment payment) {
    this.value = payment.getValue();
    this.status = payment.getStatus();
  }

  public BigDecimal getValue() {
    return value;
  }

  public PaymentStatus getStatus() {
    return status;
  }
}
