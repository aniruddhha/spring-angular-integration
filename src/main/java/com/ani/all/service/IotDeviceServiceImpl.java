package com.ani.all.service;

import com.ani.all.domain.IotDevice;
import com.ani.all.repository.IotDeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class IotDeviceServiceImpl implements IotDeviceService{

    private final IotDeviceRepository repository;

    @Override
    public IotDevice save(IotDevice device) {
        return repository.save(device);
    }

    @Override
    public List<IotDevice> devices() {
        return repository.findAll();
    }
}
