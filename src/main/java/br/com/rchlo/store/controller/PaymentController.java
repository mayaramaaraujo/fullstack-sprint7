package br.com.rchlo.store.controller;

import br.com.rchlo.store.domain.Payment;
import br.com.rchlo.store.domain.PaymentStatus;
import br.com.rchlo.store.dto.PaymentDto;
import br.com.rchlo.store.form.PaymentForm;
import br.com.rchlo.store.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Autowired
  private PaymentRepository paymentRepository;

  @Cacheable(value = "Payments")
  @GetMapping("/{id}")
  public ResponseEntity<PaymentDto> getById(@PathVariable(value = "id") Long id) {
    Optional<Payment> payment = paymentRepository.findById(id);
    if (payment.isPresent()) {
      return ResponseEntity.ok().body(new PaymentDto(payment.get()));
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  @Transactional
  public ResponseEntity<URI> postPayment(@RequestBody @Valid PaymentForm form, UriComponentsBuilder uriBuilder) {
    Payment payment = form.toConvert();
    paymentRepository.save(payment);
    URI uri = uriBuilder.path("/payment/{id}").buildAndExpand(payment.getId()).toUri();

    return ResponseEntity.created(uri).body(uri);
  }

  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<PaymentDto> toUpdate(@PathVariable Long id) {
    Optional<Payment> payment = paymentRepository.findById(id);
    if(payment.isPresent()) {
      payment.get().setStatus(PaymentStatus.CONFIRMED);
      return ResponseEntity.ok().body(new PaymentDto(payment.get()));
    }

    return ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<PaymentDto> delete(@PathVariable Long id) {
    Optional<Payment> payment = paymentRepository.findById(id);
    if(payment.isPresent()) {
      payment.get().setStatus(PaymentStatus.CANCELED);
      return ResponseEntity.ok().body(new PaymentDto(payment.get()));
    }

    return ResponseEntity.notFound().build();
  }


  @GetMapping("/clear-cache")
  @CacheEvict(value = "Payments")
  public void clearCache() {}

}
