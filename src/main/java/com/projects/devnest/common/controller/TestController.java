package com.projects.devnest.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@Tag(name = "테스트 API", description = "Swagger 테스트용 API입니다.")
public class TestController {

    @GetMapping("/hello")
    @Operation(summary = "인사말 조회", description = "간단한 인사말을 반환합니다.")
    public String hello() {
        return "Hello, Swagger!";
    }

    @PostMapping("/echo")
    @Operation(summary = "메시지 반환", description = "입력받은 메시지를 그대로 반환합니다.")
    public String echo(@RequestBody String message) {
        return "Echo: " + message;
    }
} 