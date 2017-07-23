package com.raspifi.itsallaboutleds.blink.controller;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LedBlinkController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting() {
        return "Hello, World!";
    }

    @RequestMapping("/light")
    public String light() {
        if (pin == null) {
            GpioController controller = GpioFactory.getInstance();
            pin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_01, "My LED", PinState.LOW);
        }
        pin.toggle();
        return "OK";
    }
}
