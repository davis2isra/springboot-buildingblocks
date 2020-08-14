package com.buildingblocks.bootrestv2.repositories;

import com.buildingblocks.bootrestv2.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
