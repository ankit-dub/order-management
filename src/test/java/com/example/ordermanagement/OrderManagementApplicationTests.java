package com.example.ordermanagement;

import com.example.ordermanagement.entity.User;
import com.example.ordermanagement.service.ProductOrderService;
import com.example.ordermanagement.service.StockManagementService;
import com.example.ordermanagement.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class OrderManagementApplicationTests {
//    @Autowired
//    private MockMvc mvc;
//
//    @Autowired
//    private StockManagementService productService;
//
//    @Autowired
//    private ProductOrderService orderService;
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
//        Mockito.when(productService.getProductById()).thenReturn("Mock Product Name");
//        String testName = orderService.fetchProductOrderById();
//        Assert.assertEquals("Mock Product Name", testName);
//    }
//
//    @Test
//    public void givenUser_whenGetUser_thenReturnJsonArray()
//            throws Exception {
//
//        User alex = new User();
//
//        List<User> allUsers = Arrays.asList(alex);
//
//        given(userService.fetchAllUsers()).willReturn(allUsers);
//
//        mvc.perform(get("/api/employees")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is(alex.getName())));
//    }

}
