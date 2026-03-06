package com.jitterbit.challenge.ordermanagement.mapper;

import com.jitterbit.challenge.ordermanagement.dto.ItemRequestDTO;
import com.jitterbit.challenge.ordermanagement.dto.OrderRequestDTO;
import com.jitterbit.challenge.ordermanagement.model.Order;
import com.jitterbit.challenge.ordermanagement.model.OrderItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderId, ignore = true")
    @Mapping(target = "items", source = "items")
    Order toEntity(OrderRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    @Mapping(target = "productId", source = "idItem")
    OrderItem toItemEntity(ItemRequestDTO dto);

    @AfterMapping
    default void linkItems(@MappingTarget Order order){
        if (order.getItems() != null){
            order.getItems().forEach(item -> item.setOrder(order));
        }
    }


}
