package com.ani.all.dto;

import com.ani.all.domain.IotDevice;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IotDeviceDto {
    private String nm;
    private LocalDate mdf;
    private Double lat;
    private Double lng;
    private Integer bat;

    public IotDeviceDto from(IotDevice device) {
        return new IotDeviceDto(
                device.getNm(),
                device.getMdf(),
                device.getLat(),
                device.getLng(),
                device.getBat()
        );
    }
}
