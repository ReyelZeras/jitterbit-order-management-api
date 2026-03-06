package com.jitterbit.challenge.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record ItemRequestDTO(@JsonProperty("idItem") @NotNull String idItem,
                            @JsonProperty("quantidadeItem") @NotNull Integer quantity,
                            @JsonProperty("valorItem") @NotNull Double price) {
}
