package com.poly.lab1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class Lab1Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloPage() throws Exception {
        mockMvc.perform(get("/poly/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    void testLoginSuccess() throws Exception {
        mockMvc.perform(get("/login/check")
                .param("username", "poly")
                .param("password", "123"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "Đăng nhập thành công"));
    }

    @Test
    void testLoginFail() throws Exception {
        mockMvc.perform(get("/login/check")
                .param("username", "abc")
                .param("password", "xxx"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", "Đăng nhập thất bại"));
    }

    @Test
    void testRectangle() throws Exception {
        mockMvc.perform(get("/rect/calc")
                .param("width", "5")
                .param("height", "10"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("area", 50.0))
                .andExpect(model().attribute("perimeter", 30.0));
    }
}
