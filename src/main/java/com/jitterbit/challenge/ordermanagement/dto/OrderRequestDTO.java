package com.jitterbit.challenge.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;
import java.util.List;

public record OrderRequestDTO(@JsonProperty("numeroPedido") @NotNull String orderId,
                              @JsonProperty("valorTotal") @NotNull Integer value,
                              @JsonProperty("dataCriacao") @NotNull OffsetDateTime creationDate,
                              @JsonProperty("items") @NotEmpty @Valid List<ItemRequestDTO> items) {
}


