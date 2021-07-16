package com.ani.all.service;

import com.ani.all.domain.IotDevice;

import java.util.List;

public interface IotDeviceService {

    IotDevice save(IotDevice device);

    List<IotDevice> devices();
}
