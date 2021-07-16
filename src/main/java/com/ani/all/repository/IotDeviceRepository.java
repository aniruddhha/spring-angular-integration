package com.ani.all.repository;

import com.ani.all.domain.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IotDeviceRepository extends JpaRepository<IotDevice, Long> {
}
