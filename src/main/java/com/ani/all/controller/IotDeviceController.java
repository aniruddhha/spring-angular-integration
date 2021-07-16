package com.ani.all.controller;

import com.ani.all.domain.IotDevice;
import com.ani.all.dto.AppRes;
import com.ani.all.dto.IotDeviceDto;
import com.ani.all.service.IotDeviceService;
import com.ani.all.util.AppResUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Api("Managing Iot Devices")
@AllArgsConstructor
@RequestMapping(value = "/device")
@RestController
public class IotDeviceController {

    private final IotDeviceService service;

    @ApiOperation(value = "It adds iot devices")
    @ApiResponses( value = {
            @ApiResponse(code = 200, message = "successfully added"),
            @ApiResponse(code = 400, message = "UnAuthorized access"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @PostMapping
    public ResponseEntity<AppRes<IotDeviceDto>> save(@RequestBody IotDevice device) {

        final var dv = service.save(device);
        final var dto = IotDeviceDto.builder().build();

        return ResponseEntity.ok(
                AppResUtil.buildResponse(
                dto.from(dv),
                "device saved",
                "success"
            )
        );
    }

    @ApiOperation("it lists all registered devices")
    @GetMapping
    public ResponseEntity<AppRes<List<IotDeviceDto>>> devices() {

        final var devices = service.devices()
                .stream()
                .map( dv -> IotDeviceDto.builder().build().from(dv) )
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                 AppResUtil.buildResponse(
                         devices,
                         "here is device list",
                         "success"
                 )
        );
    }
}
